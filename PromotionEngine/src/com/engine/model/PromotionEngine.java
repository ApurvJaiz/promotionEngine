package com.engine.model;

import java.util.HashMap;

public class PromotionEngine 
{
	HashMap<Character,Float> unit_price;
	HashMap<Character,Integer> unit_count;
	HashMap<Character,Float> discount_unit_price;
	public PromotionEngine(HashMap<Character, Float> unit_price, HashMap<Character, Integer> unit_count) {
		super();
		this.unit_price = unit_price;
		this.unit_count = unit_count;
		discount_unit_price=unit_price;
	}
	public HashMap<Character, Float> getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(HashMap<Character, Float> unit_price) {
		this.unit_price = unit_price;
	}
	public HashMap<Character, Integer> getUnit_count() {
		return unit_count;
	}
	public void setUnit_count(HashMap<Character, Integer> unit_count) {
		this.unit_count = unit_count;
	}

}
