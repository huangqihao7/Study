package qihao.com.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(8080));
        channel.configureBlocking(false);  // 设置非阻塞

        Selector selector = Selector.open();
        // 管道绑定到selector上，四种时间可选择，也可以多选
        channel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

        while (true){
            selector.select(); // 获取就绪数量
            Set<SelectionKey> keys = selector.selectedKeys(); // 获取就绪的个数
            Iterator<SelectionKey> it = keys.iterator();   // key的迭代器

            while (it.hasNext()){
                SelectionKey key = it.next();
                it.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                } else if (key.isReadable()){
                    SocketChannel sc = (SocketChannel) key.channel();
                    int len = sc.read(readBuffer);
                    if(len > 0){
                        readBuffer.flip();
                        String msg = new String(readBuffer.array(),0,len);
                        sc.register(selector,SelectionKey.OP_WRITE);
                        System.out.println(msg);
                        readBuffer.clear();
                    }
                } else if (key.isWritable()){
                    SocketChannel sc = (SocketChannel) key.channel();
                    writeBuffer.put("server say hello".getBytes());
                    writeBuffer.flip();
                    sc.write(writeBuffer);
                    writeBuffer.clear();
                    sc.register(selector,SelectionKey.OP_READ);
                }
            }
        }
    }
}
