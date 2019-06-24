package 网络传输序列化;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileName: Server
 * Author:   qihao
 * Date:     2019/6/3 22:29
 * Version: 1.0
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket = serverSocket.accept();

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        User user = (User) in.readObject();

        System.out.println(user);

        in.close();
        socket.close();
        serverSocket.close();
    }
}
