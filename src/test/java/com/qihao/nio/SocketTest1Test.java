package com.qihao.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SocketTest1Test {

    @Test
    public void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8088));

        sChannel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();

        sChannel.close();
    }



    @Test
    public void server() throws IOException {
        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // 设置非阻塞模式
        ssChannel.configureBlocking(false);
        // 绑定端口
        ssChannel.bind(new InetSocketAddress(8088));
        // 获取选择器
        Selector selector = Selector.open();

        // 将通道绑定到选择器上,监听就绪状态
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        int i =0;

        while (selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            System.out.println(selector.selectedKeys().size());
            while (it.hasNext()){
                SelectionKey key = it.next();
                if(key.isAcceptable()){
                    SocketChannel sChannel = ssChannel.accept();

                        sChannel.configureBlocking(false);

                        sChannel.register(selector,SelectionKey.OP_READ);


                }else if (key.isReadable()){
                    SocketChannel sChannel = (SocketChannel) key.channel();

                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }

                it.remove();
            }
        }
    }

    @Test
    public void iterator(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> it = list.iterator();
        Iterator<String> it1 = list.iterator();
        System.out.println(it.equals(it1));
       /* while (it.hasNext()){
            String str = it.next();

            System.out.println(str);
            it.remove();
        }
        System.out.println("----------------------------------------------");
        it = list.iterator();

        System.out.println();
        while (it.hasNext()){
            String str = it.next();

            System.out.println(str);
            it.remove();
        }*/
    }

}