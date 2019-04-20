package com.xiongcz.demo.parent;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class ZooTest{

    private static Logger logger = LoggerFactory.getLogger(ZooTest.class);

    private static ZooKeeper zooKeeper ;

    private static String path = "/name" ;

    @BeforeClass
    public static void beforeClass(){
        try {
            zooKeeper = new ZooKeeper("127.0.0.1",120, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    logger.info("event path[{}],event type[{}]",event.getPath(),event.getType());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate(){
        try {
            zooKeeper.create(path,"xiongcz".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSet(){
        try {
            zooKeeper.setData(path,"joker".getBytes(),-1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet(){
        Stat stat = new Stat();
        byte[] data ;
        try {
            data = zooKeeper.getData(path,false,stat);
            logger.info("data[{}],stat[{}]",new String(data),stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            zooKeeper.delete(path,-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }



}
