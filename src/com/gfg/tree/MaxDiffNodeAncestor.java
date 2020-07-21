/**
 * 
 */
package com.gfg.tree;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class MaxDiffNodeAncestor {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Making above given diagram's binary tree
		tree.root = new BinaryTreeNode<Integer>(8);
		tree.root.left = new BinaryTreeNode<Integer>(3);
		tree.root.left.left = new BinaryTreeNode<Integer>(1);
		tree.root.left.right = new BinaryTreeNode<Integer>(6);
		tree.root.left.right.left = new BinaryTreeNode<Integer>(4);
		tree.root.left.right.right = new BinaryTreeNode<Integer>(7);

		tree.root.right = new BinaryTreeNode<Integer>(10);
		tree.root.right.right = new BinaryTreeNode<Integer>(14);
		tree.root.right.right.left = new BinaryTreeNode<Integer>(13);

		System.out.println("Maximum difference between a node and" + " its ancestor is : " + maxDiff(tree.root));
	}

	static int maxDiff(BinaryTreeNode<Integer> node) {
		Res res = new Res();
		maxDiffUtil(node, res);
		return res.r;
	}

	static int maxDiffUtil(BinaryTreeNode<Integer> node, Res res) {
		if (node == null)
			return Integer.MAX_VALUE;
		if (node.left == null && node.right == null)
			return node.getData();

		int val = Math.min(maxDiffUtil(node.getLeft(), res), maxDiffUtil(node.getRight(), res));

		res.r = Math.max(res.r, node.getData() - val);
		return Math.min(val, node.getData());
	}
}

class Res {
	int r;
}