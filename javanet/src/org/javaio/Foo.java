package org.javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by LICHENG on 2018/6/14.
 */
public class Foo {

    public static void main(String args[]) {
    Properties properties = new Properties();
    try {
        FileInputStream in = new FileInputStream("test.txt");
        properties.load(in);

        for(Object key: properties.keySet()){
            System.out.println(key + ":" + properties.get(key));
        }

        properties.setProperty("e","f");
        FileOutputStream out = new FileOutputStream("test2.txt");
        properties.store(out,"comment!");
        out.close();


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    }
    public int i = 1;
    protected void ff(){
        System.out.println(i);

    }

    public <T extends Foo> void print(T t){
        t.ff();
    }



}
