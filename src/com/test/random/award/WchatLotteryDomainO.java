package com.test.random.award;


import java.io.Serializable;

/**
* 微信用户分享中奖基础数据类
* @author yanst 2016/4/23 9:36
*/
public class WchatLotteryDomainO implements Serializable{
private static final long serialVersionUID = -1595371216905016135L;

private Integer id;

//中奖金额
private String prize;

//中奖率
private Integer v;

public WchatLotteryDomainO(Integer id, String prize, Integer v){
this.id = id;
this.prize = prize;
this.v = v;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getPrize() {
return prize;
}

public void setPrize(String prize) {
this.prize = prize;
}

public Integer getV() {
return v;
}

public void setV(Integer v) {
this.v = v;
}
}
