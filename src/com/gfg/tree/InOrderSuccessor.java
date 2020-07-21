/**
 * 
 */
package com.gfg.tree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class InOrderSuccessor {

	public static void main(String[] args) {
		
	}
	
	static BinaryTreeNode<Integer> getSuccessor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> parent, BinaryTreeNode<Integer> n){
		if(n.right!=null) {
			return findMin(root.right);
		}
		BinaryTreeNode<Integer> p = parent;
		
		//https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
		return null;
	}
	
	
	static BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> curr = root;
		while(curr.left!=null) {
			curr = curr.left;
		}
		return curr;
	}
}
