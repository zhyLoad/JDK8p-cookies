/**
 * 
 */
package com.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 10007610
 *
 */
public class UDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
			/**
			 * 向服务器发送数据
			 *
			 * 定义服务器地址，端口号和数据
			 */
			InetAddress address = InetAddress.getByName("localhost");
			int port=1234;
			byte[] data ="我是：admin123，密码：123456546".getBytes();
			/**
			 * 定义一个DatagramPacket，把要发送的数据时行打包
			 */
			DatagramPacket datagramPacket = new DatagramPacket(data,data.length,address,port);
			/**
			 * 定义一个DatagramSocket，用于发送和接收数据
			 */
			DatagramSocket datagramSocket = new DatagramSocket();
			datagramSocket.send(datagramPacket);

			/**
			 * 接收服务器发送的数据
			 */
			//定义数据包的容量
			byte[] daaa= new byte[1024];
			DatagramPacket datagramPacket1 = new DatagramPacket(daaa,daaa.length);

			//用DatagramSocket接收数据
			datagramSocket.receive(datagramPacket1);

			//读取数据包的内容
			String info = new String(daaa,0,datagramPacket1.getLength());
			System.out.println("我是客户端，你说："+info);

			datagramSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
