package org.lc;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Sink;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

public class flume {

    public static void main(String[] args){
        RpcClient client = RpcClientFactory.getDefaultInstance("localhost",7888);
        client.isActive();
        Event event = EventBuilder.withBody("abcd".getBytes());
        try {
            client.append(event);
        } catch (EventDeliveryException e) {
            e.printStackTrace();
        }

    }
}
