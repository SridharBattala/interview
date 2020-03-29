package com.sree.leave.programs.datastructures.tree;

public class BinarySearchTree {
	public static Node lca(Node root, Node A, Node B) {
		if (null == root) {
			return root;
		}

		if (root.data > A.data && root.data > B.data) {
			return lca(root.left, A, B);
		}

		if (root.data < A.data && root.data < B.data) {
			return lca(root.right, A, B);
		}

		return root;
	}
	public static void main( String[] args )
    {  
       //root level 0
       Node A = Node.createNode(100);
       //Level 1
       Node B = Node.createNode(50);
       Node C = Node.createNode(150);
       //Level 2
       Node D = Node.createNode(25);
       Node E = Node.createNode(75);
       Node F = Node.createNode(125);
       Node G = Node.createNode(175);
       //Level 3
       Node H = Node.createNode(120);
       Node I = Node.createNode(140);
       Node J = Node.createNode(160);
       Node K = Node.createNode(190);
             
       //connect Level 0 and 1
       A.left = B;
       A.right = C;
       //connect level 1 and level 2
       B.left = D;
       B.right = E;
       C.left = F;
       C.right = G;
       //Connect level 2 and level 3
       F.left = H;
       F.right = I;
       G.left = J;
       G.right = K;
         
		Node ancestor = BinarySearchTree.lca(A, J, K);
       System.out.printf("Ancestor of %d and %d is %dn",J.data,K.data,ancestor.data);
       
		ancestor = BinarySearchTree.lca(A, J, G);
       System.out.printf("Ancestor of %d and %d is %dn",J.data,G.data,ancestor.data);
       
		ancestor = BinarySearchTree.lca(A, E, G);
       System.out.printf("Ancestor of %d and %d is %dn",E.data,G.data,ancestor.data);
    }
	static class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int num) {
			this.data = num;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}
		public static Node createNode(int number) {
			return new Node(number);
		}
	}
}
