/**
 * 
 */
package com.test.algorithm;

/**
 * @author 10007610  �ݹ�ʵ����
 * 쳲����������ӵ���λ��ʼ���κ�һ�����ǰ��������λ֮��
 */
public class Fibonacci {

	/**
	 * 
	 */
	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("쳲���������ӡ��ʼ��");
		for(int i=1;i <=10;i++){
			System.out.println("F("+i+")---->"+fibonacci(i));
		}

	}

}
