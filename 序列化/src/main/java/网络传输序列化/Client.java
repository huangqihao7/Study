package 网络传输序列化;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * FileName: Client
 * Author:   qihao
 * Date:     2019/6/3 22:22
 * Version: 1.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        User user = new User();
        user.setName("qihao");
        user.setAge(18);
        out.writeObject(user);

        out.close();
        socket.close();

    }

}
