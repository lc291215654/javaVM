//package org.licheng;
//
//import org.apache.hadoop.ipc.ProtocolSignature;
//
//import java.io.IOException;
//
///**
// * Created by licheng on 11/28/17.
// */
//public class ClientProtocolImpl implements ClientProtocol{
//    public String echo(String value) throws IOException {
//        return value;
//    }
//
//    public int add(int v1, int v2) throws IOException {
//        return v1 + v2;
//    }
//
//    // 重载的方法,用于获取自定义的协议版本号,
//    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
//        return ClientProtocol.versionID;
//    }
//
//    // 重载的方法,用于获取协议签名
//    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash) throws IOException {
//        return new ProtocolSignature(ClientProtocol.versionID, null);
//    }
//}
