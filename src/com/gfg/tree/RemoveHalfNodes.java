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
public class RemoveHalfNodes {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.setRoot(new BinaryTreeNode(2));
		tree.getRoot().setLeft(new BinaryTreeNode(7));
		tree.root.right = new BinaryTreeNode(5);
		tree.root.left.right = new BinaryTreeNode(6);
		tree.root.left.right.left = new BinaryTreeNode(1);
		tree.root.left.right.right = new BinaryTreeNode(11);
		tree.root.right.right = new BinaryTreeNode(9);
		tree.root.right.right.left = new BinaryTreeNode(4);

		System.out.println("the inorder traversal of tree is ");
		tree.inOrderTraversal();

		tree.setRoot(removeHalfNodes(tree.root));

		System.out.print("\nInorder traversal of the modified tree \n");
		tree.inOrderTraversal();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static BinaryTreeNode removeHalfNodes(BinaryTreeNode node) {
		if (node == null)
			return null;
		node.setLeft(removeHalfNodes(node.getLeft()));
		node.setRight(removeHalfNodes(node.getRight()));
		if(node.getLeft() == null && node.getRight() == null)
			return node;
		if (node.getLeft() == null) {
			BinaryTreeNode newNode = node.getRight();
			return newNode;
		}  if (node.getRight() == null) {
			BinaryTreeNode newNode = node.getLeft();
			return newNode;
		}
		return node;
	}
}
