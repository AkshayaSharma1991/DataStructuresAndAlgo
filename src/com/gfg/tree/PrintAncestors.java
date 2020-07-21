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
public class PrintAncestors {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode<Integer>(1);
		tree.root.left = new BinaryTreeNode<Integer>(2);
		tree.root.right = new BinaryTreeNode<Integer>(3);
		tree.root.left.left = new BinaryTreeNode<Integer>(4);
		tree.root.left.right = new BinaryTreeNode<Integer>(5);
		tree.root.left.left.left = new BinaryTreeNode<Integer>(7);

		printAncestors(tree.root, 7);
	}

	static boolean printAncestors(BinaryTreeNode<Integer> node, int k) {
		if (node == null)
			return false;
		if (node.getData() == k)
			return true;
		boolean left = printAncestors(node.getLeft(), k);
		if (left) {
			System.out.print(node.getData() + " ");
			return left;
		}
		boolean right = printAncestors(node.getRight(), k);
		if (right)
			System.out.print(node.getData() + " ");
		return right;
	}
}
