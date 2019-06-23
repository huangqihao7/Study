package qihao.com.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();

                if (key.isConnectable()){
                    SocketChannel channel = (SocketChannel) key.channel();

                    while (!channel.finishConnect());

                    channel.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                } else if (key.isWritable()) {
                    // 从当前事件中获取到对应的通道
                    SocketChannel channel = (SocketChannel) key.channel();

                    // 写出数据
                    channel.write(ByteBuffer.wrap("client say hello~~~".getBytes()));

                    // 需要去掉可写事件
                    // 获取这个通道身上的所有的事件
                    //channel.register(selector, key.interestOps() ^ SelectionKey.OP_WRITE);
                    channel.register(selector,SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 从当前事件中获取到对应的通道
                    SocketChannel channel = (SocketChannel) key.channel();

                    // 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));

                    // 需要去掉可写事件
                    // 获取这个通道身上的所有的事件
                    //channel.register(selector, key.interestOps() ^ SelectionKey.OP_READ);
                   channel.register(selector,SelectionKey.OP_WRITE);
                }

            }
        }
    }

}
