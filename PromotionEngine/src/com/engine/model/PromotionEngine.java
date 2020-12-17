package com.engine.model;

import java.util.HashMap;
public class PromotionEngine 
{
	static HashMap<Character,Float> unit_price;
	static HashMap<Character,Integer> unit_count;
	//static HashMap<Character,Float> discount_unit_price;
	private static PromotionEngine single_instance=null;
	
	protected PromotionEngine(HashMap<Character, Float> u_price, HashMap<Character, Integer> u_count) {
		super();
		unit_price = u_price;
		unit_count = u_count;
		//discount_unit_price=unit_price;
	}
	public static PromotionEngine PromotionEngine(HashMap<Character, Float> u_price, HashMap<Character, Integer> u_count)
    { 
    	if (single_instance == null) 
        { 
            single_instance = new PromotionEngine(u_price,u_count); 
        } 
        return single_instance; 
    }
	public HashMap<Character, Float> getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(HashMap<Character, Float> u_price) {
		unit_price = u_price;
	}
	public HashMap<Character, Integer> getUnit_count() {
		return unit_count;
	}
	public void setUnit_count(HashMap<Character, Integer> u_count) {
		unit_count = u_count;
	}
	/*public HashMap<Character, Float> getDiscount_unit_price() {
		return discount_unit_price;
	}*/
	public float singlePromotion(){
		float A_totalPrice=computeAmount('A',3,130);
		float B_totalPrice=computeAmount('B',2,45);
		return A_totalPrice+B_totalPrice;
	}
	public float computeAmount(char ch, int comboCount, float comboPrice)
	{
		if(!unit_count.containsKey(ch))
			return 0;
		int count=unit_count.get(ch);
		float price=unit_price.get(ch);
		float totalPrice=(count/comboCount)*comboPrice+(count%comboCount)*price;
		return totalPrice;
	}
	public float comboPromotion() {
		return computeAmount('C','D',30);
	}
	public float computeAmount(char ch1, char ch2, float comboPrice)
	{
		if((unit_count.containsKey(ch1) && unit_count.containsKey(ch2)))
		{
			int count1=unit_count.get(ch1);
			int count2=unit_count.get(ch2);
			float price1=unit_price.get(ch1);
			float price2=unit_price.get(ch2);		
			float totalPrice=Math.min(count1, count2)*comboPrice;
			if(count1>count2)
				totalPrice+=(count1-count2)*price1;
			else if(count2>count1)
				totalPrice+=(count2-count1)*price2;
			return totalPrice;
		}
		else if(unit_count.containsKey(ch1))
		{
			return unit_count.get(ch1)*unit_price.get(ch1);
		}
		else if(unit_count.containsKey(ch2))
		{
			return unit_count.get(ch2)*unit_price.get(ch2);
		}
		else
			return 0;
		/*
		float ch1TotalPrice=Math.min(count1, count2)*comboPrice+(count1-Math.min(count1, count2))*price1;
		float ch2TotalPrice=Math.min(count1, count2)*comboPrice+(count2-Math.min(count1, count2))*price2;
		discount_unit_price.put(ch1,ch1TotalPrice);
		discount_unit_price.put(ch2,ch2TotalPrice);*/	
		
	}
}

