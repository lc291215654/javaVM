package org.licheng;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;
import org.apache.hadoop.yarn.conf.YarnConfiguration;

import org.

import java.io.IOException;

/**
 * Created by licheng on 11/28/17.
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
        YarnConfiguration conf = new YarnConfiguration();
        Server server = new RPC.Builder(conf)
                .setProtocol(ClientProtocol.class)
                .setInstance(new ClientProtocolImpl())
                .setBindAddress("0.0.0.0").setPort(0)
                .setNumHandlers(2).build();

        server.start();
    }
}
