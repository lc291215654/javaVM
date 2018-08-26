package org.javaio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * Created by LICHENG on 2018/6/12.
 */
public class Test<E> {
    E[] objects;
    private String name;
    private String age;


    public class Inner{
        public int age2;
        public Inner(){
            age2 = 4;
        }

        public String toString(){
            return ":" + age2;
        }
    }

    public void display(final String name ,String age){
        class Dia{
            public Dia(){

            }
            void display(){
                System.out.println(name);
            }

        }
        new Dia().display();
    }

    <T> void fun2(List<? extends T> t){

    }
    public static void main(String[] args){

        HttpURLConnection connection = null;
        String IMAGE_PATH =  "http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png";
        try {
            URL url = new URL(IMAGE_PATH);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream in = connection.getInputStream();
                byte[] buf = new byte[1024];
                FileOutputStream fileOutputStream = new FileOutputStream("aaa.png");
                int len = 0;
                while ((len = in.read(buf)) != -1){
                    fileOutputStream.write(buf,0,len);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("  ");


    }

}
