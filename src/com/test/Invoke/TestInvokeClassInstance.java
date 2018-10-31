/**
 * 
 */
package com.test.Invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 10007610
 * ���÷�����ƣ���֪����ṹ��ǰ���£�ʵ����һ����
 *
 */
public class TestInvokeClassInstance {

	/**
	 * 
	 */
	public TestInvokeClassInstance() {

	}
	
	/**
	 * ���캯���޲���
	 */
	public void testInvokeNoParameterConstructer(){
		   try {
				Class clazz = Class.forName("com.test.Invoke.User");//ע�⣺��ȷ������
				Object obj = clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for(Method method : methods){
					if(method.getName().equals("setName")){
						method.invoke(obj, "����");
					}
				}
				User user = (User)obj;
				System.out.println("1.�û���:"+user.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * ���캯��������
	 */
	public void testInvokeContainsParameterConstructer(){
		   try {
				Class clazz = Class.forName("com.test.Invoke.User");//ע�⣺��ȷ������
				java.lang.reflect.Constructor constructor = clazz.getConstructor(String.class,int.class);
				Object obj = constructor.newInstance("����",33);
				User user = (User)obj;
				System.out.println("2.�û���:"+user.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInvokeClassInstance testInvokeClassInstance = new TestInvokeClassInstance();
		testInvokeClassInstance.testInvokeNoParameterConstructer();
		testInvokeClassInstance.testInvokeContainsParameterConstructer();
	}

}
