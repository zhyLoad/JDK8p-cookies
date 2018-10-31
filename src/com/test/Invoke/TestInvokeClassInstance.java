/**
 * 
 */
package com.test.Invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 10007610
 * 利用反射机制，在知道类结构的前提下，实例化一个类
 *
 */
public class TestInvokeClassInstance {

	/**
	 * 
	 */
	public TestInvokeClassInstance() {

	}
	
	/**
	 * 构造函数无参数
	 */
	public void testInvokeNoParameterConstructer(){
		   try {
				Class clazz = Class.forName("com.test.Invoke.User");//注意：精确到包名
				Object obj = clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for(Method method : methods){
					if(method.getName().equals("setName")){
						method.invoke(obj, "张三");
					}
				}
				User user = (User)obj;
				System.out.println("1.用户名:"+user.getName());
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
	 * 构造函数带参数
	 */
	public void testInvokeContainsParameterConstructer(){
		   try {
				Class clazz = Class.forName("com.test.Invoke.User");//注意：精确到包名
				java.lang.reflect.Constructor constructor = clazz.getConstructor(String.class,int.class);
				Object obj = constructor.newInstance("李四",33);
				User user = (User)obj;
				System.out.println("2.用户名:"+user.getName());
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
