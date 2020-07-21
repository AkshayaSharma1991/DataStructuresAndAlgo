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
public class ExpressionTree {
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<>();
		tree.root = new BinaryTreeNode<String>("+");
		tree.root.left = new BinaryTreeNode<String>("*");
		tree.root.left.left = new BinaryTreeNode<String>("5");
		tree.root.left.right = new BinaryTreeNode<String>("4");
		tree.root.right = new BinaryTreeNode<String>("-");
		tree.root.right.left = new BinaryTreeNode<String>("100");
		tree.root.right.right = new BinaryTreeNode<String>("/");
		tree.root.right.right.left = new BinaryTreeNode<String>("20");
		tree.root.right.right.right = new BinaryTreeNode<String>("2");

		System.out.println(evaluateExpression(tree.root));
	}

	static int evaluateExpression(BinaryTreeNode<String> node) {
		if (node == null)
			return 0;
		if (node.getLeft() == null && node.getRight() == null) {
			return Integer.parseInt(node.getData());
		}

		int leftVal = evaluateExpression(node.getLeft());
		int rightVal = evaluateExpression(node.getRight());

		if (node.getData().equals("+"))
			return leftVal + rightVal;
		if (node.getData().equals("-"))
			return leftVal - rightVal;
		if (node.getData().equals("*"))
			return leftVal * rightVal;
		return leftVal / rightVal;
	}
}
