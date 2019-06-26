package qihao.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class BufferTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:/test");

        ByteBuffer buffer = ByteBuffer.allocate(10);
        FileChannel channel = fis.getChannel();

        channel.read(buffer);
        System.out.println("position:" + buffer.position() + " limit:" + buffer.limit() + " capacity:" + buffer.capacity());

        buffer.flip();
        System.out.println("position:" + buffer.position() + " limit:" + buffer.limit() + " capacity:" + buffer.capacity());

        buffer.get();
        System.out.println("position:" + buffer.position() + " limit:" + buffer.limit() + " capacity:" + buffer.capacity());

        buffer.clear();
        System.out.println("position:" + buffer.position() + " limit:" + buffer.limit() + " capacity:" + buffer.capacity());

        channel.close();
        fis.close();
    }
}
