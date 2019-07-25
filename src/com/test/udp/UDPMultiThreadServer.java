/**
 * 
 */
package com.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.test.udp.threads.UDPServerThread;

/**
 * @author 10007610
 *
 */
public class UDPMultiThreadServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
			int count=0; //用于统计客户端数量
			DatagramSocket datagramSocket = new DatagramSocket(1234);

			System.out.println("```````服务器已经启动，等待客户端发送数据｀｀｀｀｀｀｀｀");


			while (true) {
			    /**
			     * 创建数据报包，用于保存收发的数据，需要定义数据包的大小和长度
			     */
			    byte[] data = new byte[1024];
			    DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
			    try {
			        datagramSocket.receive(datagramPacket);
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    if (datagramPacket.getLength() > 0) {
			        new Thread(new UDPServerThread(datagramPacket,data)).start();
			        count++;
			        System.out.println("客户端的数量为：" + count);
			    }

			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
