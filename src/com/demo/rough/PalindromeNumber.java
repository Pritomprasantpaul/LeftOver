package com.demo.rough;

import java.util.stream.IntStream;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		int number = 121;
		
		String org = String.valueOf(number);
		String rev = IntStream.rangeClosed(1, org.length())
				.mapToObj(i -> org.charAt(org.length()-i))
				.collect(StringBuilder::new , StringBuilder::append, StringBuilder::append)
				.toString();
		if(org.equals(rev))
			System.out.println("Palindrome");

	}

}
