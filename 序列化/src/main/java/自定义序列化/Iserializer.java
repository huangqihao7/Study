package 自定义序列化;

public interface Iserializer {

    <T> byte[] serializer(T obj);

    <T> T deserializer(byte[] data ,Class<T> clazz);
}
