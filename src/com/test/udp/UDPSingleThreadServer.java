/**
 * 
 */
package com.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author 10007610
 *
 */
public class UDPSingleThreadServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        try {
			/**
			 * 接收客户端数据
			 *
			 * 创建服务器端的Socket，用于收发数据，需要指定端口
			 */
			DatagramSocket datagramSocket = new DatagramSocket(1234);

			/**
			 * 创建数据报包，用于保存收发的数据，需要定义数据包的大小和长度
			 */
			byte[] data = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(data,data.length);

			System.out.println("```````服务器已经启动，等待客户端发送数据｀｀｀｀｀｀｀｀");
			/**
			 * 用Socket收取从客户端发来的数据，并保存在Packet数据报包中
			 */
			datagramSocket.receive(datagramPacket);
			String info = new String(data,0,datagramPacket.getLength());
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
			datagramSocket.send(datagramPacket1);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
