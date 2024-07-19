package com.seleniumprograms.com;

import java.util.HashMap;
import java.util.Map;

public class Duplicatewords {

	public static void main(String[] args) {
		String[] states = {"california", "New York", "Florida", "Vermont", "california"};
		
		Map<String, Integer>occ=new HashMap<>();
		 
		for(String word: states) {
			   
		     
		
			if(occ.containsKey(word)) {
				
			  occ.put(word, occ.get(word)+1);
				
			}
		}
		System.out.println(occ);
			
	}
	
}

