package com.sree.programs.patterns.dppalindromicsubsequence;

class PalindromicPartitioning {

	public static int findMPPCuts(String st) {
		return findMPPCutsRecursive(st, 0, st.length() - 1);
	}

	private static int findMPPCutsRecursive(String string, int startIndex, int endIndex) {
		if (endIndex >= startIndex && isPalindrome(string, startIndex, endIndex)) {
			return 0;
		} else {
			int minCuts = endIndex - startIndex;

			for (int i = startIndex; i <= endIndex; i++) {
				if (isPalindrome(string, startIndex, i)) {
					System.out.println("palindrome string=" + string.substring(startIndex, i + 1));
					System.out.println("check for next palindrome string=" + string.substring(i + 1, endIndex + 1));
					minCuts = Math.min(minCuts, 1 + findMPPCutsRecursive(string, i + 1, endIndex));
				}
			}
			return minCuts;
		}
	}

	private static boolean isPalindrome(String string, int startIndex, int endIndex) {
		while (endIndex >= startIndex) {
			if (string.charAt(startIndex) != string.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("min cuts=" + findMPPCuts("abdbca"));
		// System.out.println(findMPPCuts("cdpdd"));
		// System.out.println(findMPPCuts("pqr"));
		// System.out.println(findMPPCuts("pp"));
	}
}
