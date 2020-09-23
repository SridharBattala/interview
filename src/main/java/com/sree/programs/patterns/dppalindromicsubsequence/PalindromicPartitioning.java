package com.sree.programs.patterns.dppalindromicsubsequence;

class PalindromicPartitioning {

	public static int findMPPCuts(String st) {
		return findMPPCutsRecursive(st, 0, st.length() - 1);
	}

	private static int findMPPCutsRecursive(String st, int startIndex, int endIndex) {

		// we don't need to cut the string if it is a palindrome
		if (startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
			return 0;

		// at max, we need to cut the string into its 'length-1' pieces
		int minimumCuts = endIndex - startIndex;
		for (int i = startIndex; i <= endIndex; i++) {
			if (isPalindrome(st, startIndex, i)) {
				System.out.println("string 1=" + st.substring(startIndex, i + 1));
				System.out.println("string 2=" + st.substring(i + 1, endIndex + 1));

				// we can cut here as we have a palindrome from 'startIndex' to 'i'
				minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i + 1, endIndex));
			}
		}

		return minimumCuts;
	}

	private static boolean isPalindrome(String st, int x, int y) {
		while (x < y) {
			if (st.charAt(x++) != st.charAt(y--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(findMPPCuts("abdbca"));
		// System.out.println(findMPPCuts("cdpdd"));
		// System.out.println(findMPPCuts("pqr"));
		// System.out.println(findMPPCuts("pp"));
	}
}
