package com.engine.service;

import java.util.HashMap;

public class InitializeInputService 
{

	public HashMap<Character,Float> initializeInput() 
	{
		HashMap<Character,Float> unit_price=new HashMap<Character,Float>(); 
		unit_price.put('A', (float) 50);
		unit_price.put('B', (float) 30);
		unit_price.put('C', (float) 20);
		unit_price.put('D', (float) 15);
		return unit_price;
	}
}
