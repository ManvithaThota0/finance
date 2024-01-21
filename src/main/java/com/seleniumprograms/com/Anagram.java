package com.seleniumprograms.com;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		//Check if two strings are Anagram
		
		String str1="race";
		String str2="care";
		
		//compare if length is equal
		//else Not Anagram
		//length is equal: convert strings to char array
		//sort array
		//check both arrays are equal
		//print String is anagram
		//else not anagram
		
		
		if(str1.length()==str2.length()) {
			
			char[] CharArray1=str1.toCharArray();
			char[] CharArray2=str2.toCharArray();
	
		Arrays.sort(CharArray1);
		Arrays.sort(CharArray2);
		
		if(Arrays.equals(CharArray1, CharArray2)) {
			System.out.println(str1+"and"+str2+"are Anagram");
		}
		else {
			System.out.println(str1+"and"+str2+"are not Anagram");
		}
		
		}
		
		else {
			System.out.println(str1+"and"+str2+"are not Anagram");
		}

	}

}
