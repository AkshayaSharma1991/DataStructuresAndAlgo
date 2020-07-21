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
public class LowestCommonAncestor {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		
		System.out.println(findLCA(tree.getRoot(), 10, 2).getData());
	}

	static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, int x, int y) {
		if (root == null)
			return null;
		if (root.getData() == x || root.getData() == y)
			return root;

		BinaryTreeNode<Integer> left = findLCA(root.getLeft(), x, y);
		BinaryTreeNode<Integer> right = findLCA(root.getRight(), x, y);

		if (left != null && right != null)
			return root;

		return (left != null) ? left : right;

	}

}
