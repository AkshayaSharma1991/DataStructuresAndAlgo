/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class MinDiffBetweenNodes {

	static BinaryTreeNode<Integer> prev;
	static int ans;

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(3);
		root.right = new BinaryTreeNode(7);
		root.left.left = new BinaryTreeNode(2);
		root.left.right = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(8);
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.root = root;
		System.out.println(minDiff(root));
	}

	static int minDiff(BinaryTreeNode<Integer> root) {
		prev = null;
		ans = Integer.MAX_VALUE;
		inOrder(root);
		return ans;
	}

	static void inOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.getLeft());
			if (prev != null)
				ans = Math.min(ans, node.getData() - prev.getData());
			prev = node;
			inOrder(node.getRight());
		}
	}
}
