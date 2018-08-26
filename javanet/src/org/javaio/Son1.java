package org.javaio;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by LICHENG on 2018/6/14.
 */
public class Son1 extends Foo {
    public static void main(String args[]) {
//        InputStream inputStream = new FileInputStream();
        try {

//            FileReader reader = new FileReader(new File("a.txt"));
            FileOutputStream stream = new FileOutputStream(new File("testoutput"));
            stream.write("ÄãºÃ".getBytes("utf-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testoutput")));
            String s = null;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
    }


    protected void ff1(int i ,float f){

    }

    protected void ff1(float i ,int f){

    }

    public void selector() throws IOException{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(8000));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                }else if((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true){
                        buffer.clear();
                        int n = sc.read(buffer);
                        if(n < 0){
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }
    }


}
