package com.engine.model;

import java.util.HashMap;

public class SinglePromotion extends PromotionEngine
{
	public SinglePromotion(HashMap<Character, Float> unit_price, HashMap<Character, Integer> unit_count) {
		super(unit_price, unit_count);
	}
	public void singlePromotion()
	{
		//3 As for 130
		float A_totalPrice=computeAmount('A',3,130);
		//2 Bs for 45
		float B_totalPrice=computeAmount('B',2,45);
//		float C_totalPrice=computeAmount('B',2,45);
//		float D_totalPrice=computeAmount('B',2,45);
		
		discount_unit_price.put('A',(A_totalPrice < discount_unit_price.get('A'))?A_totalPrice:discount_unit_price.get('A'));
		discount_unit_price.put('B',(B_totalPrice < discount_unit_price.get('B'))?B_totalPrice:discount_unit_price.get('B'));
//		discount_unit_price.put('C',(C_totalPrice < discount_unit_price.get('C'))?C_totalPrice:discount_unit_price.get('C'));
//		discount_unit_price.put('D',(D_totalPrice < discount_unit_price.get('D'))?D_totalPrice:discount_unit_price.get('D'));

	}
	public float computeAmount(char ch, int comboCount, float comboPrice)
	{
		int count=unit_count.get(ch);
		float price=unit_price.get(ch);
		float totalPrice=(count/comboCount)*comboPrice+(count%comboCount)*price;
		return totalPrice;
	}
	

}
