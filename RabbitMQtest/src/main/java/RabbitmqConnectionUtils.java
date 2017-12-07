import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitmqConnectionUtils {
	private static ConnectionFactory factory;
	private static Connection connection;
	private static Channel channel;

	private static String mqhost = "192.168.1.217";
	private static String mqport = "5672";
	private static String mquser = "admin";
	private static String mqpassword = "123456";
	private static String messageTTL = "86400000";

	public static void loadConnectionFactory() {
		if (factory == null) {
			PropertiesUtil p;
			try {
//				p = new PropertiesUtil();
//				mqhost = p.readValue("mqhost");
//				mqport = p.readValue("mqport");
//				mquser = p.readValue("mquser");
//				mqpassword = p.readValue("mqpassword");
//				messageTTL = p.readValue("messageTTL");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			factory = new ConnectionFactory();
			factory.setHost(mqhost);
			factory.setPort(Integer.parseInt(mqport));
			factory.setUsername(mquser);
			factory.setPassword(mqpassword);
			factory.setAutomaticRecoveryEnabled(true);
			factory.setConnectionTimeout(100000);
		}
	}

	public static void reloadChannel() {
		try {
			if (factory == null) {
				loadConnectionFactory();
			}
			if (connection != null && connection.isOpen()) {
			} else {
				connection = factory.newConnection();
			}
			channel = connection.createChannel();
		} catch (IOException  e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static Channel getChannel() {
		if (channel != null && channel.isOpen()) {
			return channel;
		} else {
			reloadChannel();
			return channel;
		}
	}

	public static void sendMessageByRoutingKeyNoClosed(String routingKey, String message) {
		try {
			AMQP.BasicProperties properties;
			if (messageTTL != null && !messageTTL.equalsIgnoreCase("")) {
				properties = new AMQP.BasicProperties(null, "UTF-8", null, null,
						null, null, null,messageTTL, null,
						null,null, null, null, null);
			} else {
				properties = new AMQP.BasicProperties(null, "UTF-8", null, null,
						null, null, null,"86400000", null,
						null,null, null, null, null);
			}
			getChannel().basicPublish("amq.direct", routingKey, properties, message.getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		sendMessageByRoutingKeyNoClosed("student","hello world!");
	}
}
