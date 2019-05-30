package com.qihao.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * FileName: SocketTest1
 * Author:   qihao
 * Date:     2019/5/14 23:10
 * Version: 1.0
 */
public class SocketTest1 {

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

              //  it.remove();
            }
        }
    }

}
