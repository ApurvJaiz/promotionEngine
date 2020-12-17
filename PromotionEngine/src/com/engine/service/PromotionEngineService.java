package com.engine.service;

import java.util.HashMap;

import com.engine.model.*;

public class PromotionEngineService 
{
	PromotionEngine promotionEngine;
	PromotionEngine singlePromotionEngine;
	PromotionEngine comboPromotionEngine;
	public PromotionEngineService(HashMap<Character, Float> unit_price, HashMap<Character, Integer> unit_count) 
	{
		promotionEngine=PromotionEngine.PromotionEngine(unit_price,unit_count);
		singlePromotionEngine=SinglePromotion.PromotionEngine(unit_price,unit_count);
		comboPromotionEngine=ComboPromotion.PromotionEngine(unit_price,unit_count);
	}
	public float totalPrice()
	{
		singlePromotionEngine.singlePromotion();
		comboPromotionEngine.comboPromotion();
		float total_price=0;
		for(Character ch: promotionEngine.getDiscount_unit_price().keySet())
		{
			total_price+=promotionEngine.getDiscount_unit_price().get(ch);
		}
		return total_price;
	}

}
