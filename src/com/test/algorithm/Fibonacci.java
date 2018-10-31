/**
 * 
 */
package com.test.algorithm;

/**
 * @author 10007610  递归实例：
 * 斐波那契数：从第三位开始，任何一项都等于前面相邻两位之和
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
		System.out.println("斐波那契数打印开始：");
		for(int i=1;i <=10;i++){
			System.out.println("F("+i+")---->"+fibonacci(i));
		}

	}

}
