package com.sree.programs.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
public static void main(String args[]) {
    System.out.println("Length of the longest substring: " + 
NoRepeatSubstring.findLength("aabccbb"));

}
public static int findLength(String input) {
	int windowStart=0;
	Map<Character,Integer> countMap=new HashMap<>();
	int maxLength=0;
	for(int windowEnd=0;windowEnd<input.length();windowEnd++) {
		Character endCharacter=input.charAt(windowEnd);
		//add char to count map
		countMap.put(endCharacter,countMap.getOrDefault(endCharacter, 0)+1);
		//check for duplicate char
		int endCharCount=countMap.get(endCharacter);
		if(endCharCount>1) {
			//shrink the window
			while(windowEnd>windowStart) {
				Character startCharacter=input.charAt(windowStart);
				//remove character
				countMap.put(startCharacter,countMap.getOrDefault(startCharacter, 0)-1);
				windowStart++;
				if(countMap.get(endCharacter)==1) {
					break;
				}
				
			}
		}
		
		maxLength=Math.max(maxLength,(windowEnd-windowStart)+1 );
		System.out.println("start="+windowStart+" end="+windowEnd+" maxLength="+maxLength);
	}
	return maxLength;
	
}
}
