package com.sree.programs.datastructures.strings;

/**
 * Tushar vedio https://www.youtube.com/watch?v=l3hda49XcDE
 * 
 * @author sbattala
 *
 */
public class RegularExpressionMatch {
	public static boolean regxMatchRec(String text, String pattern, int textIndex, int patternIndex) {
		// base case
		if (text.length() == textIndex && pattern.length() == patternIndex) {
			return true;
		}
		// recursive case
		else {
			// * case
			if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {
				for (int k = textIndex; k < text.length(); k++) {
					if (regxMatchRec(text, pattern, k, patternIndex + 2)) {
						return true;
					}

					if (k >= text.length()) {
						return false;
					}

					if (pattern.charAt(patternIndex) != '.' && text.charAt(k) != pattern.charAt(patternIndex)) {
						return false;
					}
				}
			}
			// . and character case
			else if (textIndex < text.length() && patternIndex < pattern.length()
					&& (pattern.charAt(patternIndex) == '.'
							|| pattern.charAt(patternIndex) == text.charAt(textIndex))) {
				return regxMatchRec(text, pattern, textIndex + 1, patternIndex + 1);
			}

			return false;
		}
	}

	public static boolean regxMatch(String text, String pattern) {
		return regxMatchRec(text, pattern, 0, 0);
	}

	public static void main(String[] args) {
		String s = "fabbbc";
		String p = ".ab*c";
		boolean output2 = regxMatch(s, p);

		if (output2) {
			System.out.print(s + " " + p + " match");
		} else {
			System.out.print(s + " " + p + " did not match.");
		}
	}
}