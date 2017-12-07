import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

public class SyncObserver2 extends BaseRegionObserver {

    private static final Log LOG = LogFactory.getLog(SyncObserver2.class);

    @Override
    public void start(CoprocessorEnvironment env) throws IOException {
        //LOG.info(" start() begin");
    }

    @Override
    public void stop(CoprocessorEnvironment e) throws IOException {
        //LOG.info(" stop() begin");
    }

    public String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    @Override
    public void postPut(ObserverContext<RegionCoprocessorEnvironment> e,
                        Put put,
                        WALEdit edit,
                        Durability durability) {
        try {
            //获取表的名称
            byte[] table = e.getEnvironment().getRegion().getRegionInfo().getTable().getName();
            String tableName = Bytes.toString(table);

            if (tableName.contains("hbase:meta"))
                return;

            String rowkey = new String(put.getRow());
            NavigableMap<byte[], List<Cell>> familyMap = put.getFamilyCellMap();
            Map<String, Object> json = new HashMap<String, Object>();
            for (Map.Entry<byte[], List<Cell>> entry : familyMap.entrySet()) {
                for (Cell cell : entry.getValue()) {
                    String cf = Bytes.toString(cell.getFamily());
                    String col = Bytes.toString(cell.getQualifier());
                    String value = Bytes.toString(cell.getValue());
                    long timestamp = cell.getTimestamp();
                    String newrow = encode(rowkey.getBytes("UTF-8"));
                    String newvalue = encode(value.getBytes("UTF-8"));
                    String message = "put" + (char) 1 + tableName + (char) 1 + newrow + (char) 1 + cf + ":" + col + (char) 1 + newvalue + (char) 1 + timestamp;
                    RabbitmqConnectionUtils.sendMessageByRoutingKeyNoClosed(tableName, message);
                }
            }
        } catch (Exception ex) {
            LOG.error(ex);
        }
    }

    @Override
    public void postDelete(final ObserverContext<RegionCoprocessorEnvironment> e,
                           final Delete delete,
                           final WALEdit edit,
                           final Durability durability) {
        try {
            //获取表的名称
            byte[] table = e.getEnvironment().getRegion().getRegionInfo().getTable().getName();
            String tableName = Bytes.toString(table);
            String rowkey = new String(delete.getRow());
            NavigableMap<byte[], List<Cell>> familyMap = delete.getFamilyCellMap();
            for (Map.Entry<byte[], List<Cell>> entry : familyMap.entrySet()) {
                for (Cell cell : entry.getValue()) {
                    long timestamp = cell.getTimestamp();
                    String cf = Bytes.toString(cell.getFamily());
                    String col = Bytes.toString(cell.getQualifier());
                    String value = Bytes.toString(cell.getValue());
                    String newrow = encode(rowkey.getBytes("UTF-8"));
                    String newvalue = encode(value.getBytes("UTF-8"));
                    String message = "delete" + (char) 1
                            + tableName + (char) 1
                            + newrow + (char) 1
                            + cf + ":" + col + (char) 1
                            + newvalue + (char) 1
                            + timestamp;
                    RabbitmqConnectionUtils.sendMessageByRoutingKeyNoClosed(tableName, message);
                }
            }
        } catch (Exception ex) {
            LOG.error(ex);
        }
    }
}
