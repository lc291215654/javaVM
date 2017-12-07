import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.hadoop.hbase.HRegionInfo;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.coprocessor.BaseMasterObserver;
import org.apache.hadoop.hbase.coprocessor.MasterCoprocessorEnvironment;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SyncObserverMaster extends BaseMasterObserver {

    private static String QUEUE_NAME = "hbase_sync";

    private static ConnectionFactory factory;

    private static String mqhost;
    private static String mqport;
    private static String mquser;
    private static String mqpassword;
    private static boolean isLoad = false;

    private void readConfig() {
        if (isLoad) {
            return;
        }
        PropertiesUtil p;
        try {
            p = new PropertiesUtil();
            mqhost = p.readValue("mqhost");
            mqport = p.readValue("mqport");
            mquser = p.readValue("mquser");
            mqpassword = p.readValue("mqpassword");
            QUEUE_NAME = p.readValue("queuename");
        } catch (Exception ex) {
            mqhost = "192.168.1.53";
            mqport = "5672";
            mquser = "admin";
            mqpassword = "admin";
            QUEUE_NAME = "hbase_sync";
        }
        factory = new ConnectionFactory();
        factory.setHost(mqhost);
        factory.setPort(Integer.parseInt(mqport));
        factory.setUsername(mquser);
        factory.setPassword(mqpassword);

    }

    @Override
    public void postCreateTableHandler(final ObserverContext<MasterCoprocessorEnvironment> ctx,
                                       HTableDescriptor desc, HRegionInfo[] regions) throws IOException {
        Connection connection;
        try {
            String tableName = desc.getTableName().getNameAsString();
            if (factory == null) {
                readConfig();
            }
            connection = factory.newConnection();
            // 创建一个频道  
            Channel channel = connection.createChannel();
            // 指定一个队列  
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送的消息  
            String message = "create" + (char) 1 + tableName + (char) 1 + "none" + (char) 1 + "none" + (char) 1 + "none";
            // 往队列中发出一条消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            // 关闭频道和连接  
            channel.close();
            connection.close();
        } catch (TimeoutException ez) {
            ez.printStackTrace();
        }
    }

    @Override
    public void postDeleteTableHandler(final ObserverContext<MasterCoprocessorEnvironment> ctx, TableName tableName) throws IOException {

        Connection connection;

        try {
            if (factory == null) {
                readConfig();
            }
            connection = factory.newConnection();
            // 创建一个频道
            Channel channel = connection.createChannel();
            // 指定一个队列  
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送的消息  
            String message = "drop" + (char) 1 + tableName + (char) 1 + "none" + (char) 1 + "none" + (char) 1 + "none";
            // 往队列中发出一条消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            // 关闭频道和连接  
            channel.close();
            connection.close();
        } catch (TimeoutException ez) {
            // TODO Auto-generated catch block
            ez.printStackTrace();
        }

    }
}
