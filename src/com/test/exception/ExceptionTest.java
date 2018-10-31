/**
 * 
 */
package com.test.exception;

/**
 * @author 10007610
 *
 */
public class ExceptionTest {
	
	
	/**
	 * 1����ʹTry���Ѿ�Return�ˣ�Finally��Ҳִ��
	 */
	public static void testA(){
		
		try {
			System.out.println("enter try");
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("you get finally!");
		}
		
	}
	
	/**
	 * 2����ʹcatch���Ѿ�Return�ˣ�Finally��Ҳִ��
	 */
	public static void testB(){
		
		try {
			System.out.println("enter try");
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("enter catch");
			return;
		} finally{
			System.out.println("you get finally!");
		}
		
	}
	
	/**
	 * 3.��ʹcatch�м����������쳣��Finally��Ҳִ��
	 */
	public static void testC() throws Exception{
		
		try {
			System.out.println("enter try");
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("enter catch");
			throw new Exception();
		} finally{
			System.out.println("you get finally!");
		}
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//testA();
		//testB();
		try {
			testC();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
