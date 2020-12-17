package com.engine.service;

import java.util.HashMap;

import com.engine.model.*;

public class PromotionEngineService 
{
	PromotionEngine promotionEngine;
	SinglePromotion singlePromotionEngine;
	ComboPromotion comboPromotionEngine;
	public PromotionEngineService(HashMap<Character, Float> unit_price, HashMap<Character, Integer> unit_count) 
	{
		//promotionEngine=PromotionEngine.PromotionEngine(unit_price,unit_count);
		singlePromotionEngine=new SinglePromotion(unit_price,unit_count);
		comboPromotionEngine=new ComboPromotion(unit_price,unit_count);
	}
	public float totalPrice()
	{
		float p1=singlePromotionEngine.singlePromotion();
		float p2=comboPromotionEngine.comboPromotion();
		float total_price=p1+p2;
		/*for(Character ch: promotionEngine.getDiscount_unit_price().keySet())
		{
			total_price+=promotionEngine.getDiscount_unit_price().get(ch);
		}*/
		return total_price;
	}

}
