/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 * Approach: Set right to left and left to right
 */
public class MirrorofBinaryTree {

	public static void main(String[]  args) {
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
		
		tree.levelOrder();
		
		mirror(tree);
		System.out.println();
		tree.levelOrder();
	}
	
	static void mirror(BinaryTree<Integer>  tree) {
		tree.setRoot(mirrorRec(tree.getRoot()));
	}
	
	static BinaryTreeNode<Integer> mirrorRec(BinaryTreeNode<Integer> node) {
		if(node == null)
			return null;
		else {
			BinaryTreeNode<Integer> left = mirrorRec(node.getLeft());
			BinaryTreeNode<Integer> right  = mirrorRec(node.getRight());
			
			node.setRight(left);
			node.setLeft(right);
			return node;
		}
	}
}
