package com.engine.service;

import java.util.HashMap;

public class InputProcessingService 
{

	public char[] splitInput(String input) 
	{
		//input=input.trim();
		String splitRegex="\\s+";
		String SKU[]=input.trim().split(splitRegex);
		char sku_id[]=new char[SKU.length];
		int count=0;
		for(String str:SKU)
		{
			sku_id[count++]=str.charAt(0);
		}
		return sku_id;
	}

	public HashMap<Character, Integer> getUnitCount(char[] sku_id) 
	{
		HashMap<Character, Integer> unit_count=new HashMap<Character, Integer>();
		for(Character ch:sku_id)
		{
			if(!unit_count.containsKey(ch))
				unit_count.put(ch, 0);
			int count=unit_count.get(ch);
			unit_count.put(ch, count+1);			
		}
		return unit_count;
	}
	

}
