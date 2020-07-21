/**
 * 
 */
package com.gfg.tree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class HeightOfSpiralTree {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);

		root.left = new BinaryTreeNode<Integer>(2);
		root.right = new BinaryTreeNode<Integer>(3);
		root.left.left = new BinaryTreeNode<Integer>(4);
		root.left.right = new BinaryTreeNode<Integer>(5);
		root.left.left.left = new BinaryTreeNode<Integer>(6);

		// Given tree contains 3 leaf nodes
		BinaryTreeNode<Integer> L1 = root.left.left.left;
		BinaryTreeNode<Integer> L2 = root.left.right;
		BinaryTreeNode<Integer> L3 = root.right;

		// create circular doubly linked list out of
		// leaf nodes of the tree

		// set next pointer of linked list
		L1.right = L2;
		L2.right = L3;
		L3.right = L1;

		// set prev pointer of linked list
		L3.left = L2;
		L2.left = L1;
		L1.left = L3;

		// calculate height of the tree
		System.out.println("Height of tree is " + getHeight(root));
	}

	static int getHeight(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		if (isLeaf(root))
			return 1;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	static boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left != null && root.left.right == root && root.right != null && root.right.left == root;
	}
}
