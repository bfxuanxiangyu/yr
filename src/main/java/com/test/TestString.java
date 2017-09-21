package com.test;

public class TestString{
	
	public static void testString(){
		StringBuffer sb = new StringBuffer();
		sb.append("test");
		sb.append("ab");
		sb.delete(3,4);
		sb.insert(3, "t");
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	public static void testMath(){
		System.out.println(Math.round(11.5)+" | "+Math.round(11.4)+" | "+Math.round(-11.5)+" | "+Math.round(-11.4));
	}
	
	public static void main(String[] args) {
		testMath();
		testString();
	}

}
