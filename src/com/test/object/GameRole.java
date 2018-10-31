/**
 * 
 */
package com.test.object;

/**
 * @author dell
 *
 */
public abstract class GameRole {
	
	protected int score ;
	
	protected int liveFlag;//0-死；1-活
	
	protected String roleName;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLiveFlag() {
		return liveFlag;
	}

	public void setLiveFlag(int liveFlag) {
		this.liveFlag = liveFlag;
	}
	

	
	public void showRoleInformation(){
		System.out.println(roleName+"的情况为：");
		if(this.liveFlag==0){
			System.out.println("死翘翘啦");
		}else{
			System.out.println("你已经得了 "+this.score+" 分");
			System.out.println("活着呢，想干啥干啥");
		}
	}
	
	public abstract void fight(GameRole role);
	
	public abstract void dealFight();
}
