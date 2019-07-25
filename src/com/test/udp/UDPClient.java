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
			 * ���������������
			 *
			 * �����������ַ���˿ںź�����
			 */
			InetAddress address = InetAddress.getByName("localhost");
			int port=1234;
			byte[] data ="���ǣ�admin123�����룺123456546".getBytes();
			/**
			 * ����һ��DatagramPacket����Ҫ���͵�����ʱ�д��
			 */
			DatagramPacket datagramPacket = new DatagramPacket(data,data.length,address,port);
			/**
			 * ����һ��DatagramSocket�����ڷ��ͺͽ�������
			 */
			DatagramSocket datagramSocket = new DatagramSocket();
			datagramSocket.send(datagramPacket);

			/**
			 * ���շ��������͵�����
			 */
			//�������ݰ�������
			byte[] daaa= new byte[1024];
			DatagramPacket datagramPacket1 = new DatagramPacket(daaa,daaa.length);

			//��DatagramSocket��������
			datagramSocket.receive(datagramPacket1);

			//��ȡ���ݰ�������
			String info = new String(daaa,0,datagramPacket1.getLength());
			System.out.println("���ǿͻ��ˣ���˵��"+info);

			datagramSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
