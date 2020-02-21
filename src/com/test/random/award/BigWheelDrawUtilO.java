/**
 * 
 */
package com.test.random.award;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;

/**
 * @author 10007610
 *
 */
public class BigWheelDrawUtilO {

	private static  Gson gson = new Gson();
    /**
     * ��ת�̵�ÿ���Ƕȸ���ʼֵ
     * @return
     */
    private final static List<WchatLotteryDomainO> initDrawList = new ArrayList<WchatLotteryDomainO>() {{
//        add(new WchatLotteryDomainO(1, "200", 1));//�н���1/10000000
//        add(new WchatLotteryDomainO(2, "100", 30000));//�н���30000/10000000
//        add(new WchatLotteryDomainO(3, "50", 300));//�н���300/10000000
//        add(new WchatLotteryDomainO(4, "30", 30));//�н���30/10000000
//        add(new WchatLotteryDomainO(5, "20", 26));//�н���26/10000000
//        add(new WchatLotteryDomainO(6, "1", 999999));//�н���909999/10000000
        add(new WchatLotteryDomainO(1, "200", 20));//�н���1/10000000
        add(new WchatLotteryDomainO(2, "100", 30));//�н���30000/10000000
        add(new WchatLotteryDomainO(3, "50", 50));//�н���300/10000000
    }};

    /**
     * ���ɽ���
     * @return
     */
    public static WchatLotteryDomainO generateAward(int maxLimit) {
        long result = randomnum(1, maxLimit);
        int line = 0;
        int temp = 0;
        WchatLotteryDomainO returnobj = null;
        for (int i = 0; i < initDrawList.size(); i++) {
        	WchatLotteryDomainO obj2 = initDrawList.get(i);
            int c = obj2.getV();
            temp = temp + c;
            line = maxLimit - temp;
            if (c != 0) {
                if (result > line && result <= (line + c)) {
                    returnobj = obj2;
                    break;
                }
            }
        }
        return returnobj;
    }
    
    /**
     * ���ɽ���
     * @return
     */
    public static WchatLotteryDomainO generateAward1(int maxLimit) {
    	long random = randomnum(0, maxLimit);
		int stepTotal = 0;
      //probability ->key �ǽ�Ʒid ->prod�ǽ�ƷȨ��
		for(WchatLotteryDomainO wchatLotteryDomainO : initDrawList)
		{
			int proba = wchatLotteryDomainO.getV();
			int min = stepTotal;
			int max = stepTotal + proba;
			stepTotal = max;
			//��������Ž���ͬ��Ͱ
			if(random>min && random<=max)
			{
				return wchatLotteryDomainO;
			}
		}
		
		return null;
    }

    // ��ȡ2��ֵ֮��������
    private static long randomnum(int smin, int smax){
            int range = smax - smin;
            double rand = Math.random();
            return (smin + Math.round(rand * range));
    }
    
    
    public static int getRandom(int min, int max){
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        return i;
    }


    public static void main(String[] args) {
//        System.out.println(gson.toJson(generateAward(10000000)));//����0��10000000֮������齱
    	System.out.println(getRandom(1,100));
    	 System.out.println(gson.toJson(generateAward1(100)));//����0��10000000֮������齱
    }

}