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
public class DistanceBetweenNodes {

	public static void main(String[] args) {
		BinaryTree<Integer> tree1 = new BinaryTree<>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		root.left = new BinaryTreeNode<Integer>(2);
		root.right = new BinaryTreeNode<Integer>(3);
		root.left.left = new BinaryTreeNode<Integer>(4);
		root.left.right = new BinaryTreeNode<Integer>(5);
		root.right.left = new BinaryTreeNode<Integer>(6);
		root.right.right = new BinaryTreeNode<Integer>(7);
		root.right.left.right = new BinaryTreeNode<Integer>(8);
		tree1.root = root;

		System.out.println(findDistance(tree1.root, 8, 5));
	}

	static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.getData() == n1 || root.getData() == n2)
			return root;
		BinaryTreeNode<Integer> left = findLCA(root.getLeft(), n1, n2);
		BinaryTreeNode<Integer> right = findLCA(root.getRight(), n1, n2);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;

	}

	static int findDistance(BinaryTreeNode<Integer> root, int n1, int n2) {
		BinaryTreeNode<Integer> lca = findLCA(root, n1, n2);
		int d1 = findLevel(lca, n1, 0);
		int d2 = findLevel(lca, n2, 0);

		return d1 + d2;
	}

	static int findLevel(BinaryTreeNode<Integer> root, int n, int level) {
		if (root == null)
			return -1;
		if (root.getData() == n)
			return level;
		int left = findLevel(root.getLeft(), n, level + 1);
		if (left == -1) {
			return findLevel(root.getRight(), n, level + 1);
		} else
			return left;
	}
}
