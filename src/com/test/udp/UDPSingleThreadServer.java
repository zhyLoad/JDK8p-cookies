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
			 * ���տͻ�������
			 *
			 * �����������˵�Socket�������շ����ݣ���Ҫָ���˿�
			 */
			DatagramSocket datagramSocket = new DatagramSocket(1234);

			/**
			 * �������ݱ��������ڱ����շ������ݣ���Ҫ�������ݰ��Ĵ�С�ͳ���
			 */
			byte[] data = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(data,data.length);

			System.out.println("```````�������Ѿ��������ȴ��ͻ��˷������ݣ��������");
			/**
			 * ��Socket��ȡ�ӿͻ��˷��������ݣ���������Packet���ݱ�����
			 */
			datagramSocket.receive(datagramPacket);
			String info = new String(data,0,datagramPacket.getLength());
			System.out.println("���Ƿ��������ͻ��˷��͵���Ϣ�ǣ�"+ info);

			/**
			 * ��Ӧ�ͻ�������
			 *
			 * �ӽ��յ����ݰ��л�ȡ�ͻ��˵ĵ�ַ�Ͷ˿�
			 */
			InetAddress address = datagramPacket.getAddress();
			int port = datagramPacket.getPort();
			//������Ӧ����
			byte[] data2 = "�������Ѿ��յ������Ϣ��лл��".getBytes();

			//��DatagramPacket��Ҫ���͵����ݽ��д��
			DatagramPacket datagramPacket1 = new DatagramPacket(data2,data2.length,address,port);

			//��datagramSocket�����ݰ����͸��ͻ���
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
