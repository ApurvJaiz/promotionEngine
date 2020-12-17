package com.engine.test;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import com.engine.service.PromotionEngineService;
public class MainTest {

	@Test
	public void test1() 
	{
		double actual, expected;
		PromotionEngineService promotionEngineService;
		//SKU and price
		HashMap<Character,Float> unit_price=new HashMap<Character,Float>();
		unit_price.put('A', (float) 50);
		unit_price.put('B', (float) 30);
		unit_price.put('C', (float) 20);
		unit_price.put('D', (float) 15);
		
		//Case 1
		HashMap<Character,Integer> unit_count=new HashMap<Character,Integer>();
		unit_count.put('A', 1);
		unit_count.put('B', 1);
		unit_count.put('C', 1);
		
		expected=(float) 100.0;
		promotionEngineService=new PromotionEngineService(unit_price,unit_count);
		actual=promotionEngineService.totalPrice();
		
		Assert.assertEquals(actual,expected,0.00001);
		
		//Case 2
		unit_count.put('A', 5);
		unit_count.put('B', 5);
		unit_count.put('C', 1);
		unit_count.put('D', 0);
		
		expected=(float) 370.0;
		promotionEngineService=new PromotionEngineService(unit_price,unit_count);
		actual=promotionEngineService.totalPrice();
		
		Assert.assertEquals(actual,expected,0.00001);
		
		//Case 3
		unit_count.put('A', 1);
		unit_count.put('B', 1);
		unit_count.put('C', 1);
		unit_count.put('D', 1);
		
		expected=(float) 110.0;
		promotionEngineService=new PromotionEngineService(unit_price,unit_count);
		actual=promotionEngineService.totalPrice();
		
		Assert.assertEquals(actual,expected,0.00001);
		
		//Case 4
		unit_count.put('A', 3);
		unit_count.put('B', 5);
		unit_count.put('C', 1);
		unit_count.put('D', 1);
		
		expected=(float) 280.0;
		promotionEngineService=new PromotionEngineService(unit_price,unit_count);
		actual=promotionEngineService.totalPrice();
		
		Assert.assertEquals(actual,expected,0.00001);

		
	}
}
