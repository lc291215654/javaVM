package org.javanet;

import sun.misc.Unsafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import static sun.misc.Unsafe.getUnsafe;

/**
 * Created by licheng on 1/4/18.
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
//        InetAddress ip = InetAddress.getByName("localhost");
//        boolean r = ip.isReachable(5000);
//        System.out.println(r);
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost.getHostName());
//        System.out.println(localHost.getCanonicalHostName());
        Socket socket = new Socket("www.baidu.com",80);
        System.out.println(socket.getRemoteSocketAddress());
        System.out.println(socket.getLocalSocketAddress());
        System.out.println(socket.getChannel());
        BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Client:"+is.readLine());





    }
}


class Cat extends Thread{
    public static void sleep(){

        System.out.println("My sleep!");

    }
}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}