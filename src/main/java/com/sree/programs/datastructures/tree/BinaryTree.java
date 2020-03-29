package com.sree.leave.programs.datastructures.tree;

import java.util.ArrayList;
import java.util.Collections;

/*
 * http://www.makeinjava.com/lca-lowest-least-common-ancestor-binary-tree-recursive-example/
 */
public class BinaryTree {
	public static ArrayList path;
	/**
	 * 
	 * @param root
	 * @param dest
	 * @return
	 */
	public  static boolean printPath(final Node root, final Node dest) {
		if (root == null)
			return false;
		if (root == dest || printPath(root.left, dest) || printPath(root.right, dest)) {
			// System.out.print(" " + root.data);
			path.add(root.data);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static int heightOfTree(Node root) {
		if (null == root)
			return 0;
		int hLeftSub = heightOfTree(root.left);
		int hRightSub = heightOfTree(root.right);
		return Math.max(hLeftSub, hRightSub) + 1;
	}
	/**
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
    public static Node lca(final Node root, final Node node1, final Node node2) {
    	//System.out.println("ss");
    	int rootData=root==null?0:root.data;
    	int node1Data=node1==null?0:node1.data;
    	int node2Data=node2==null?0:node2.data;
    	System.out.println("root="+ rootData+", node1="+ node1Data+", node2="+ node2Data);

    	//System.out.println("root="+ root==null?0:root.data+", node1="+ node1!=null?node1.data:0+", node2="+ node2!=null?node2.data:0);
    	if (null == root) {
            return root;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Node left = lca(root.left, node1, node2);
        int leftData=left==null?0:left.data;
        System.out.println("left="+ leftData);

        Node right = lca(root.right, node1, node2);
        int rightData=right==null?0:right.data;
        System.out.println("right="+ rightData);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
    
    public static int findDistance(final Node root, final Node n1, final Node n2) {
		final int x = pathlength(root, n1.data) - 1;
		final int y = pathlength(root, n2.data) - 1;
		final int lcaData = lca(root, n1, n2).data;
		final int lcaDistance = pathlength(root, lcaData) - 1;
		System.out.println("x="+x+",y="+y+",lcaDistance="+lcaDistance);
		return (x + y) - 2 * lcaDistance;
	}

	public static int pathlength(final Node root, final int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = pathlength(root.left, n1)) > 0 || (x = pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}
    public static void preOrder(Node root) {
		if (null == root) {
			return;
		}
		System.out.printf("%d ", root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if (null == root) {
			return;
		}
		postOrder(root.left);		
		postOrder(root.right);
		System.out.printf("%d ", root.data);
	}
	
	public static void inOrder(Node root) {
		if (null == root)
			return;
		inOrder(root.left);
		System.out.printf("%d ", root.data);
		inOrder(root.right);
	}
    public static void main(final String[] args) {// root level 0
        Node A = Node.createNode(50);
        // Level 1
        Node B = Node.createNode(25);
        Node C = Node.createNode(75);
        // Level 2
        Node D = Node.createNode(15);
        Node E = Node.createNode(40);
        Node F = Node.createNode(60);
        Node G = Node.createNode(95);

        // Level 3
        Node H = Node.createNode(10);
        Node I = Node.createNode(20);
        Node J = Node.createNode(30);
        Node K = Node.createNode(45);
        Node L = Node.createNode(55);
        Node M = Node.createNode(65);

        // connect Level 0 and 1
        A.left = B;
        A.right = C;
        // connect level 1 and level 2
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        // connect level 2 and level 3
        D.left = H;
        D.right = I;
        E.left = J;
        E.right = K;
        F.left = L;
        F.right = M;
        //lca
        Node lca = BinaryTree.lca(A, D, H);
        String message = String.format("1. LCA[Node D (%d) & Node H (%d)] = %d", D.data, H.data, lca.data);
        System.out.println(message);

       //height
        System.out.println("height="+BinaryTree.heightOfTree(A));
        System.out.println("distance="+BinaryTree.findDistance(A, D, H));
        //print path to root node
        path = new ArrayList();
		printPath(A, H);
		Collections.reverse(path);
		System.out.println(" Path " + path);
		
    }

    
}
