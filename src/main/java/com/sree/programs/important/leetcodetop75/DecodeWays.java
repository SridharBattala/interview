package com.sree.programs.important.leetcodetop75;

public class DecodeWays {
	public static void main(String args[]) {

		System.out.println("count=" + numDecodings("1234"));

	}

	public static int numDecodings(String a) {
		return waysToDecodeRec(a, a.length() - 1);
	}

	public static int waysToDecodeRec(String a, int end) {

		if (end < 0)
			return 1;

		int count = 0;

		if (a.charAt(end) > '0')
			count = waysToDecodeRec(a, end - 1);

		if (isValid(a, end)) {
			count = count + waysToDecodeRec(a, end - 2);
		}

		return count;
	}

	public static boolean isValid(String str, int index) {
		if (index > 0 && (str.charAt(index - 1) == '1' || str.charAt(index - 1) == '2' && str.charAt(index) < '7'))
			return true;

		return false;
	}

}
