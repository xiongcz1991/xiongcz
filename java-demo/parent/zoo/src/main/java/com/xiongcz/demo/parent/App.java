package com.xiongcz.demo.parent;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args ){

        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1",120,null);
            zooKeeper.create("/name","xiongcz".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
