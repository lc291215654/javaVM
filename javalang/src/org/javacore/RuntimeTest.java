package org.javacore;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by licheng on 3/15/18.
 */
public class RuntimeTest {

    public static void main(String args[]){
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        try {
            Process process = runtime.exec("ls");
            InputStream ins = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader br = new BufferedReader(isr);
            String result = br.readLine();
            System.out.println(result);
            result = br.readLine();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
