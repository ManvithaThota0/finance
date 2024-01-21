package com.seleniumprograms.com;

public class Duplicates {

	public static void main(String[] args) {
		String str="maaannvvvitha";
		int Count=0;
		char[] ch=str.toCharArray();
		
		for(int i=0;i<str.length();i++) {
			
			for(int j=i+1;j<str.length();j++) {
				
				if(ch[i]==ch[j]) {
					
					Count++;
					System.out.println("String has duplicates");
					
				}
			}
			
		}

	}

}
