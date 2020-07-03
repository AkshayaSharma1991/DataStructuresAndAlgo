/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *Approach : Max(leftTreeHt, rightTreeHt) + 1
 *
 */
public class HeightOfSubtree {

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
		
		System.out.println("Height of  tree: " + height(tree));
	}
	
	static int height(BinaryTree<Integer> tree) {
		return heightRec(tree.getRoot());
	}
	
	static int heightRec(BinaryTreeNode<Integer>  node) {
		if(node == null)
			return 0;
		else {
			int lHeight = heightRec(node.getLeft());
			int rHeight = heightRec(node.getRight());
			
			return Math.max(lHeight, rHeight) + 1;
		}
	}
}
