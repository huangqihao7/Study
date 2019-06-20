package qihao.com.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream out = null;
        InputStream input = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            socket = serverSocket.accept();

            input = socket.getInputStream();

            byte[] bytes = new byte[1024];
            int read = input.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));


            out = socket.getOutputStream();
            out.write("我很好，thx".getBytes());

            out.close();
            input.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
