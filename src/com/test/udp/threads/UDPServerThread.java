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
    DatagramPacket datagramPacket;  //���ݱ���
    byte[] data1;  //������ݵı���
 

    public UDPServerThread(DatagramPacket datagramPacket,byte[] data1) {
        this.datagramPacket = datagramPacket;
        this.data1=data1;
    }
    
    
    public void run() {

//        byte[] data=new byte[1024];
        String info = new String(data1,0,datagramPacket.getLength());
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
        try {
            DatagramSocket datagramSocket= new DatagramSocket();
            datagramSocket.send(datagramPacket1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
