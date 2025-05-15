package com.amazon_in_Test;

import java.util.HashSet;
import java.util.Set;

public class eye {

	public static void main(String[] args) {
		String s="hellow";
		char[] ch=s.toCharArray();  //int i=0;i<=size-1;i++
		int size=s.length();
		
		
		Set set=new HashSet<>();
		StringBuffer sb=new StringBuffer();
		for(char c:ch) {
			if(!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}
		

}
}