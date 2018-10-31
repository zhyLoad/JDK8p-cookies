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
		Dragon dragon1 = new Dragon(10,1,"怪物1");
		Dragon dragon2= new Dragon(2,1,"怪物2");
		Hero hero = new Hero(100,1,"英雄");
		
		System.out.println("一开始情况统计：");
		dragon1.showRoleInformation();
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		System.out.println("英雄打一下怪物2啦");
		hero.fight(dragon2);
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		System.out.println("英雄又打一下怪物2啦");
		hero.fight(dragon2);
		dragon2.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("怪物1打一下英雄啦");
		dragon1.fight(hero);
		dragon1.showRoleInformation();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("英雄补血啦");
		hero.award = "加分奖励";
		hero.addScore();
		hero.showRoleInformation();
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
	
		
	}

}
