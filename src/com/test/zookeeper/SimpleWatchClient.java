package com.test.zookeeper;



import org.apache.zookeeper.*;
import java.io.IOException;

/**
 * Created by 10007610 on 2019/9/4.
 * 娴嬭瘯鐩戞祴Zookeeper鑺傜偣鐨勫�肩殑鍙樺寲鎯呭喌
 */
public class SimpleWatchClient implements Runnable {

    public static final String ZNODE = "/CONF/uams/default/dataSource_init_url";

    private static ZooKeeper zk;


    public SimpleWatchClient()throws IOException{
        zk = new ZooKeeper("10.0.251.142:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
            }
        });
    }


    @Override
    public void run() {
         Watcher wc = new Watcher() {
             @Override
             public void process(WatchedEvent event) {
                 System.out.println("-------------------Start to execute Watcher.process--------------");

                 try {
                     String zkData = new String(zk.getData(ZNODE,true,null));
                     System.out.println("The electricity charge is :" +zkData);
                 } catch (KeeperException e) {
                     e.printStackTrace();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         };

         while(true){
             System.out.println("+++++++++++++ Continuously watching specific ZNODE...++++++++++++");
             try {
                 zk.exists(ZNODE,wc);
             } catch (KeeperException e) {
                 e.printStackTrace();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }


    public static void main(String[] args){
        try {
            SimpleWatchClient client = new SimpleWatchClient();
            Thread th = new Thread(client);
            th.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
