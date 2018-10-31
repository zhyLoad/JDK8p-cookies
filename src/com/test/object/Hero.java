/**
 * 
 */
package com.test.object;

/**
 * @author dell
 *
 */
public class Hero extends GameRole {

	public String award;
	
	


	public Hero(int score,int liveFlag,String roleName){
		this.score  = score;
		this.liveFlag = liveFlag;
		this.roleName = roleName;
	}
	

	@Override
	public void dealFight() {
		this.score = this.score-2;
	}




	@Override
	public void fight(GameRole role) {
		if(role instanceof Dragon){
			role.dealFight();
		}
	}
	
	public void showAward(){
		System.out.println("我得了"+this.award+"奖励");
	}
	
	public void addScore(){
		if("加分奖励".equals(award)){
			this.score = this.score+1;
		}
	}
}
