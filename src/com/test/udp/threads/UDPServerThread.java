/**
 * 
 */
package com.test.udp.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 10007610
 *
 */
public class UDPServerThread implements Runnable{
    DatagramPacket datagramPacket;  //数据报包
    byte[] data1;  //存放数据的变量
 

    public UDPServerThread(DatagramPacket datagramPacket,byte[] data1) {
        this.datagramPacket = datagramPacket;
        this.data1=data1;
    }
    
    
    public void run() {

//        byte[] data=new byte[1024];
        String info = new String(data1,0,datagramPacket.getLength());
        System.out.println("我是服务器，客户端发送的信息是："+ info);

        /**
         * 响应客户端数据
         *
         * 从接收的数据包中获取客户端的地址和端口
         */
        InetAddress address = datagramPacket.getAddress();
        int port = datagramPacket.getPort();
        //定义响应数据
        byte[] data2 = "服务器已经收到你的信息，谢谢！".getBytes();

        //用DatagramPacket把要发送的数据进行打包
        DatagramPacket datagramPacket1 = new DatagramPacket(data2,data2.length,address,port);

        //用datagramSocket把数据包发送给客户端
        try {
            DatagramSocket datagramSocket= new DatagramSocket();
            datagramSocket.send(datagramPacket1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
