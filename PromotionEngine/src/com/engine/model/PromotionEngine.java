package com.engine.model;

import java.util.HashMap;
public class PromotionEngine 
{
	static HashMap<Character,Float> unit_price;
	static HashMap<Character,Integer> unit_count;
	static HashMap<Character,Float> discount_unit_price;
	private static PromotionEngine single_instance=null;
	
	protected PromotionEngine(HashMap<Character, Float> u_price, HashMap<Character, Integer> u_count) {
		super();
		unit_price = u_price;
		unit_count = u_count;
		discount_unit_price=unit_price;
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
	public HashMap<Character, Float> getDiscount_unit_price() {
		return discount_unit_price;
	}
	public void singlePromotion(){}
	public void comboPromotion() {}

}
