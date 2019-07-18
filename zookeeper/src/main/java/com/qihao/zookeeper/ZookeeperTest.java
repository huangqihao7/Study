package com.qihao.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Author: huangqihao
 * @Date: 2019/7/18 23:04
 */
public class ZookeeperTest {

    public static void main(String[] args) throws IOException {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.56.10:2181,192.168.56.20:2181,192.168.56.30:2181")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .build();
        client.start();
        deleteZookeeperNode(client);

        //System.in.read();
    }

    public static void createZookeeperNode(CuratorFramework client){
        try {
            for (int i = 0; i < 10; i++) {
                client.create().creatingParentsIfNeeded().
                        withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/test/a","0".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateZookeeperNode(CuratorFramework client){
        try {
            client.setData().forPath("/data/program","up".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteZookeeperNode(CuratorFramework client){
        Stat stat = new Stat();
        try {
            String value = new String(client.getData().storingStatIn(stat).forPath("/data/program"));
            System.out.println(value);
            client.delete().withVersion(stat.getVersion()).forPath("/data/program");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
