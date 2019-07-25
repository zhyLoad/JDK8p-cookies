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
			int count=0; //����ͳ�ƿͻ�������
			DatagramSocket datagramSocket = new DatagramSocket(1234);

			System.out.println("```````�������Ѿ��������ȴ��ͻ��˷������ݣ��������");


			while (true) {
			    /**
			     * �������ݱ��������ڱ����շ������ݣ���Ҫ�������ݰ��Ĵ�С�ͳ���
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
			        System.out.println("�ͻ��˵�����Ϊ��" + count);
			    }

			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
