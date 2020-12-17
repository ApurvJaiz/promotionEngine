package com.engine;

import java.util.HashMap;
import java.util.Scanner;

import com.engine.service.InitializeInputService;
import com.engine.service.InputProcessingService;
import com.engine.service.PromotionEngineService;
public class PromotionEngineApp 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the list of all the SKU characters in the cart: ");
		String input=sc.nextLine();		
		
		//processing the input
		InputProcessingService processInput=new InputProcessingService();
		char sku_id[]=processInput.splitInput(input);
		
		//Getting the count of each SKU
		HashMap<Character,Integer> unit_count=processInput.getUnitCount(sku_id);
		
		//Initialize the price and name of the inventory items
		InitializeInputService initialize=new InitializeInputService();
		HashMap<Character,Float> unit_price=initialize.initializeInput();
		
		for(Character ch:unit_count.keySet())
		{
			System.out.println(ch+": "+unit_count.get(ch));
		}
		for(Character ch:unit_price.keySet())
		{
			System.out.println(ch+": "+unit_price.get(ch));
		}
		
		PromotionEngineService promotionEngineService=new PromotionEngineService(unit_price,unit_count);
		System.out.println(promotionEngineService.totalPrice());
		
		
		/*for(Character ch:unit_count.keySet())
		{
			System.out.println(ch+": "+unit_count.get(ch));
		}*/
		
		
		
		sc.close();
	}

}
