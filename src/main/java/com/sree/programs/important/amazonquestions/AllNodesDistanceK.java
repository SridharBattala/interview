package com.sree.programs.important.amazonquestions;

import com.sree.programs.datastructures.tree.TreeNode;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
import java.util.*;

public class AllNodesDistanceK {
	static TreeNode targetNode = null;

	public static void main(String args[]) {
		TreeNode TreeNode0 = new TreeNode(0);
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);
		TreeNode TreeNode6 = new TreeNode(6);
		TreeNode TreeNode7 = new TreeNode(7);
		TreeNode TreeNode8 = new TreeNode(8);
		TreeNode3.left = TreeNode5;
		TreeNode3.right = TreeNode1;

		TreeNode5.left = TreeNode6;
		TreeNode5.right = TreeNode2;

		TreeNode1.left = TreeNode0;
		TreeNode1.right = TreeNode8;

		TreeNode2.left = TreeNode7;
		TreeNode2.right = TreeNode4;

		System.out.println(" distanceK=" + distanceK(TreeNode3, 5, 2));
	}

	public static List<Integer> distanceK(TreeNode root, int target, int targetDistance) {
		List<Integer> output = new LinkedList<>();
		// anotate parent
		Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
		anotateParent(root, parentNodeMap);
		System.out.println("parentNodeMap=" + parentNodeMap.toString());
		// get target node using node value
		searchNodeByValue(root, target);
		System.out.println("targetNode=" + targetNode != null ? targetNode.data : null);

		// do BFS from target node
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(targetNode);
		List<TreeNode> visitedList = new LinkedList<>();
		visitedList.add(targetNode);
		int currentDistance = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			System.out.println("current queue elements" + queue.toString());
			for (int i = 0; i < queueSize; i++) {
				TreeNode currentNode = queue.poll();
				if (currentDistance == targetDistance) {
					output.add(currentNode.data);
				}
				if (currentNode.left != null && !visitedList.contains(currentNode.left)) {
					visitedList.add(currentNode.left);
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null && !visitedList.contains(currentNode.right)) {
					visitedList.add(currentNode.right);
					queue.offer(currentNode.right);
				}
				if (parentNodeMap.containsKey(currentNode) && !visitedList.contains(parentNodeMap.get(currentNode))) {
					visitedList.add(parentNodeMap.get(currentNode));
					queue.offer(parentNodeMap.get(currentNode));
				}
			}
			currentDistance++;
		}
		return output;

	}

	private static void searchNodeByValue(TreeNode root, int target) {
		if (root == null) {
			return;
		} else if (root.data == target) {
			targetNode = root;
			return;
		} else {
			searchNodeByValue(root.left, target);
			searchNodeByValue(root.right, target);
		}
	}

	private static void anotateParent(TreeNode root, Map<TreeNode, TreeNode> parentNodeMap) {
		if (root == null) {
			return;
		} else {
			System.out.println("root==" + root.data);
			if (root.left != null) {
				parentNodeMap.put(root.left, root);
			}
			if (root.right != null) {
				parentNodeMap.put(root.right, root);
			}
			anotateParent(root.left, parentNodeMap);
			anotateParent(root.right, parentNodeMap);
		}

	}
}
