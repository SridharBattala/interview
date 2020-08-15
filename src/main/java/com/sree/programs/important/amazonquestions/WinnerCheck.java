package com.sree.programs.important.amazonquestions;

public class WinnerCheck {
	public static void main(String[] args) {
		String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart1 = { "orange", "apple", "apple", "banana", "orange", "banana" };
		String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingCart2 = { "banana", "orange", "banana", "apple", "apple" };
		System.out.println("output=" + checkWinner(codeList1, shoppingCart1));
		System.out.println("output=" + checkWinner(codeList2, shoppingCart2));
	}

	private static int checkWinner(String[][] codeList, String[] shoppingCart) {
		int codeListRowIndex = 0;
		int codeListColIndex = 0;
		int shoppingCartIndex = 0;
		int matchedRowCount = 0;
		for (int row = 0; row < codeList.length && shoppingCartIndex < shoppingCart.length; row++) {
			// check in first row string match any sub string of shoppingCart
			int matchedCount = 0;
			for (int col = 0; col < codeList[row].length && shoppingCartIndex < shoppingCart.length;) {
				if (codeList[row][col].equals(shoppingCart[shoppingCartIndex])
						|| codeList[row][col].equals("anything")) {
					col++;
					shoppingCartIndex++;
					matchedCount++;
				} else {
					shoppingCartIndex++;
				}
			}
			if (matchedCount == codeList[row].length) {
				matchedRowCount++;
			}

		}
		if (matchedRowCount == codeList.length) {
			return 1;
		}
		return 0;
	}
}
