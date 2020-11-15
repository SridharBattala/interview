package com.sree.programs.important.leetcodetop75;

import java.util.*;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 * 
 * 
 * @author sbattala
 *
 */
public class SerializeDeserialize {

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

		SerializeDeserialize object = new SerializeDeserialize();
		String serializedString = object.serialize(TreeNode1);
		System.out.println(" serialize=" + serializedString);
		TreeNode root = object.deserialize(serializedString);
		System.out.println("root.data=" + root.data);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return serializeRecursion(root, "");
	}

	// dfs preorder traversal
	public String serializeRecursion(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "null,";
		} else {
			str += String.valueOf(root.data) + ",";
			str = serializeRecursion(root.left, str);
			str = serializeRecursion(root.right, str);
		}
		return str;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return deserializeRecursion(data_list);
	}

	public TreeNode deserializeRecursion(List<String> list) {
		// Recursive deserialization.
		if (list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		root.left = deserializeRecursion(list);
		root.right = deserializeRecursion(list);

		return root;
	}
}
