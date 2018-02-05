package org.javanet;

import java.io.IOException;

/**
 * Created by licheng on 1/4/18.
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
//        InetAddress ip = InetAddress.getByName("localhost");
//        boolean r = ip.isReachable(5000);
//        System.out.println(r);


        char[] a = {'a','f','d','a','f','a','s','d','d'};
        char b = '\141';
        System.out.println(b);




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