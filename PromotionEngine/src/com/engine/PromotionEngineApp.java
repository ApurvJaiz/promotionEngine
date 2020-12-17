package com.engine;

import java.util.HashMap;
import java.util.Scanner;

import com.engine.service.InputProcessingService;
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
		//Getting the count of each sku
		HashMap<Character,Integer> unit_count=processInput.getUnitCount(sku_id);
		/*for(Character ch:unit_count.keySet())
		{
			System.out.println(ch+": "+unit_count.get(ch));
		}*/
		
		
		
		sc.close();
	}

}