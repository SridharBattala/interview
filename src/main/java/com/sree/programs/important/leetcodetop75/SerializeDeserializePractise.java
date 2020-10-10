package com.sree.programs.important.leetcodetop75;

import java.util.*;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 * 
 * @author sbattala
 *
 */
public class SerializeDeserializePractise {
	static int index = 0;

	public static void main(String args[]) {
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);

		TreeNode1.left = TreeNode2;
		TreeNode1.right = TreeNode5;
		TreeNode2.left = TreeNode3;
		TreeNode2.right = TreeNode4;

		String serializedString = serialize(TreeNode1);
		System.out.println(" serialize=" + serializedString);
		TreeNode root = deserialize(serializedString);
		System.out.println("printPreOrder");
		printPreOrder(root);
	}

	private static TreeNode deserialize(String serializedString) {
		String[] stringArray = serializedString.split(",");
		return deserializeRecursive(stringArray);
	}

	private static TreeNode deserializeRecursive(String[] stringArray) {
		if (index >= stringArray.length || stringArray[index].equals("null")) {
			index++;
			return null;
		} else {
			TreeNode root = new TreeNode(Integer.valueOf(stringArray[index]));
			index++;
			root.left = deserializeRecursive(stringArray);
			root.right = deserializeRecursive(stringArray);
			return root;
		}

	}

	private static void printPreOrder(TreeNode root) {
		if (root == null) {
			System.out.print("null,");
			return;
		} else {
			System.out.print(root.data + ",");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	private static String serialize(TreeNode root) {
		return serializeRecursive(root, "");
	}

	private static String serializeRecursive(TreeNode root, String serializeString) {
		if (root == null) {
			serializeString = serializeString + "null" + ",";
			return serializeString;
		} else {
			System.out.println("root.data=" + root.data + ", serializeString=" + serializeString);
			serializeString = serializeString + root.data + ",";
			serializeString = serializeRecursive(root.left, serializeString);
			serializeString = serializeRecursive(root.right, serializeString);
			return serializeString;
		}
	}

}
