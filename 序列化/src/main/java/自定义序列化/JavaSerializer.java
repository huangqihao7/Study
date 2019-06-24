package 自定义序列化;

import java.io.*;

/**
 * FileName: JavaSerializer
 * Author:   qihao
 * Date:     2019/6/3 23:11
 * Version: 1.0
 */
public class JavaSerializer implements Iserializer {

    @Override
    public <T> byte[] serializer(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);

            out.writeObject(obj);

            return  byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayOutputStream);

            return (T) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
