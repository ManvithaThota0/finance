package com.seleniumprograms.com;

public class Duplicates {

	public static void main(String[] args) {
		String str="maaannvvvitha";
		   int count=0;
		for(int i=0; i<str.length();i++) {
			for(int j=i+1;j<str.length();j++) {
				
				char[] ch=str.toCharArray();
				
				if(ch[i]==ch[j]) {
					count++;
					
				}
								
				}
			}
			
		}

	}


