/**
 * 
 */
package com.test.object;

/**
 * @author dell
 *
 */
public class GameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dragon dragon1 = new Dragon(10,1,"����1");
		Dragon dragon2= new Dragon(2,1,"����2");
		Hero hero = new Hero(100,1,"Ӣ��");
		
		System.out.println("һ��ʼ���ͳ�ƣ�");
		dragon1.showRoleInformation();
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Ӣ�۴�һ�¹���2��");
		hero.fight(dragon2);
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Ӣ���ִ�һ�¹���2��");
		hero.fight(dragon2);
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("����1��һ��Ӣ����");
		dragon1.fight(hero);
		dragon1.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("Ӣ�۲�Ѫ��");
		hero.award = "�ӷֽ���";
		hero.addScore();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
	
		
	}

}
