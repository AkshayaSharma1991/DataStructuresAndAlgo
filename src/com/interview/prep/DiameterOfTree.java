/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class DiameterOfTree {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		System.out.println("Diameter: " + diameter(tree));
	}
	
	static int diameter(BinaryTree<Integer> tree) {
		return diameter(tree.getRoot());
	}
	
	static int diameter(BinaryTreeNode<Integer> node) {
		if(node  == null)
			return 0;
		else {
			int lHeight = height(node.getLeft());
			int rHeight = height(node.getRight());
			
			int lDiameter = diameter(node.getLeft());
			int rDiameter = diameter(node.getRight());
			
			return Math.max(lHeight+rHeight+1, Math.max(lDiameter, rDiameter));
		}
	}
	
	static int height(BinaryTreeNode<Integer> node) {
		if(node == null)
			return 0;
		else {
			return 1+ Math.max(height(node.getLeft()), height(node.getRight()));
		}
	}
}
