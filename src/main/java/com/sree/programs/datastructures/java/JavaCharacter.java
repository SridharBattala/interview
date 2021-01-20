package com.sree.programs.datastructures.java;

import java.util.*;

public class JavaCharacter {
	public static void main(String[] args) {
		/**
		 * string methods
		 */
		Character character = new Character('a');
		System.out.println("isDigit=" + Character.isLetterOrDigit('1'));
		System.out.println("isDigit=" + Character.isDigit('1'));
		System.out.println("isAlphabet=" + Character.isAlphabetic('i'));
		System.out.println("isLowerCase=" + Character.isLowerCase('i'));
		System.out.println("isUpperCase=" + Character.isUpperCase('S'));
		System.out.println("toUpperCase=" + Character.toUpperCase('s'));
		System.out.println("toLowerCase=" + Character.toLowerCase('S'));
		System.out.println("getNumericValue=" + Character.getNumericValue('a'));
		System.out.println("char to int=" + (int) 'a');
		System.out.println("char to int=" + (int) 'z');
		System.out.println("char to int=" + (int) 'A');
		System.out.println("char to int=" + (int) 'Z');
		System.out.println("char to int=" + ((int) 'Z' - (int) 'X'));
		System.out.println("char to int=" + (char) 97);
		System.out.println("char to string=" + Character.toString((char) 258));// non ascii unicorn character
		System.out.println("char to string=" + Character.toString((char) 257));// non ascii unicorn character
	}
}
