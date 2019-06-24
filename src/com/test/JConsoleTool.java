/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 *  ���������������
 *  -Xms100M -Xms100m -XX:+UseSerialGC -XX:+PrintGCDetails
 */
public class JConsoleTool {
	
	 static class OOMObject {
	        public byte[] placeholder = new byte[64 * 1024];
	 }
	 
	 public static void fillHeap(int num) throws InterruptedException { 
		 Thread.sleep(20000); //�����г�����ִ�м�� 
		 List<OOMObject> list = new ArrayList<OOMObject>(); 
		 for (int i = 0; i < num; i++) { // ������ʱ����������ߵı仯�������� 
			 Thread.sleep(50); 
			 list.add(new OOMObject()); 
		 }
		 System.gc(); 
	 } 


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  try {
			fillHeap(1000);
	        while(true){
	            //����һֱ������
	        }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
