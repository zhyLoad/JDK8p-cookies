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
	
	protected int liveFlag;//0-����1-��
	
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
		System.out.println(roleName+"�����Ϊ��");
		if(this.liveFlag==0){
			System.out.println("��������");
		}else{
			System.out.println("���Ѿ����� "+this.score+" ��");
			System.out.println("�����أ����ɶ��ɶ");
		}
	}
	
	public abstract void fight(GameRole role);
	
	public abstract void dealFight();
}
