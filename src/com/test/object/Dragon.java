/**
 * 
 */
package com.test.object;

/**
 * @author dell
 *
 */
public class Dragon extends GameRole {
	
	public Dragon(int score,int liveFlag,String roleName){
		this.score  = score;
		this.liveFlag = liveFlag;
		this.roleName = roleName;
	}

	@Override
	public void dealFight() {
		if(this.score>0){
			this.score = this.score-1;
		}else{
			System.out.println("已经死了，不用打了");
		}
			
		if(this.score==0){
			this.liveFlag = 0;
		}
	}

	@Override
	public void fight(GameRole role) {
		if(role instanceof Hero){
			role.dealFight();
		}
	}

	
}
