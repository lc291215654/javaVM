package org.javaio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by licheng on 3/14/18.
 */
public class TestChannelRead {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        // 获取通道
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取数据到缓冲区
        fileChannel.read(buffer);

        // 重设buffer，将limit设置为position，position设置为0
        buffer.flip();

        // 查看在position和limit之间是否有元素
        while (buffer.hasRemaining()) {
            // 读取buffer当前位置的整数
            byte b = buffer.get();
            System.out.print((char) b);
        }

        fileInputStream.close();
    }
}
