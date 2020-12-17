package com.engine.model;

import java.util.HashMap;

public class ComboPromotion extends PromotionEngine
{

	public ComboPromotion(HashMap<Character, Float> unit_price, HashMap<Character, Integer> unit_count) {
		super(unit_price, unit_count);
	}
	public void singlePromotion()
	{
		//C+D=30
		computeAmount('C','D',30);
	}
	public void computeAmount(char ch1, char ch2, float comboPrice)
	{
		int count1=unit_count.get(ch1);
		int count2=unit_count.get(ch2);
		float price1=unit_price.get(ch1);
		float price2=unit_price.get(ch2);		
		float ch1TotalPrice=Math.min(count1, count2)*comboPrice+(count1-Math.min(count1, count2))*price1;
		float ch2TotalPrice=Math.min(count1, count2)*comboPrice+(count2-Math.min(count1, count2))*price2;
		discount_unit_price.put(ch1,(ch1TotalPrice < discount_unit_price.get(ch1))?ch1TotalPrice:discount_unit_price.get(ch1));
		discount_unit_price.put(ch2,(ch2TotalPrice < discount_unit_price.get(ch2))?ch1TotalPrice:discount_unit_price.get(ch2));
	}
}
