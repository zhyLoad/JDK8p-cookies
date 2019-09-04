package com.test.zookeeper;


import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by 10007610 on 2019/9/4.
 */
public class ZookeeperTest {

    public static void main(String[] args) throws Exception {
//        // 鍒濆鍖� ZooKeeper 瀹炰緥(zk 鍦板潃銆佷細璇濊秴鏃舵椂闂达紝涓庣郴缁熼粯璁や竴鑷淬�亀atcher)
//        ZooKeeper zk = new ZooKeeper("10.0.251.142:2181,10.0.251.97:2181", 30000, new Watcher() {
//            @Override
//            public void process(WatchedEvent event) {
//                System.out.println("浜嬩欢绫诲瀷涓猴細" + event.getType());
//                System.out.println("浜嬩欢鍙戠敓鐨勮矾寰勶細" + event.getPath());
//                System.out.println("閫氱煡鐘舵�佷负锛�" + event.getState());
//            }
//        });
//        // 鍒涘缓涓�涓洰褰曡妭鐐�
//        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
//        // 鍒涘缓涓�涓瓙鐩綍鑺傜偣
//        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(new String(zk.getData("/testRootPath", false, null)));
//         //鍙栧嚭瀛愮洰褰曡妭鐐瑰垪琛�
//        System.out.println(zk.getChildren("/CONF/uams/default", true));
//        // 淇敼瀛愮洰褰曡妭鐐规暟鎹�
//        zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
//        System.out.println("鐩綍鑺傜偣鐘舵�侊細[" + zk.exists("/testRootPath", true) + "]");
//        // 鍒涘缓鍙﹀涓�涓瓙鐩綍鑺傜偣
//        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));
//        // 鍒犻櫎瀛愮洰褰曡妭鐐�
//        zk.delete("/testRootPath/testChildPathTwo", -1);
//        zk.delete("/testRootPath/testChildPathOne", -1);
//        // 鍒犻櫎鐖剁洰褰曡妭鐐�
//        zk.delete("/testRootPath", -1);
//        zk.close();


        /***
         * 娴嬭瘯鑾峰彇Zookeeper鑺傜偣淇℃伅
         */
        String connectString = "10.0.251.142:2181";
        int sessionTimeout = 4000;
        Watcher watcher = new Watcher() {
            public void process(WatchedEvent event) {
                //System.out.println(event.getPath());
            }
        };
        try {
            ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
            List<String> list = zooKeeper.getChildren("/CONF/uams/default", false);
            for (String path : list) {
                System.out.println("path="+path);
                byte[] b = zooKeeper.getData("/CONF/uams/default/"+path, false, null) ;
                System.out.println("content=["+new String(b)+"]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


}
