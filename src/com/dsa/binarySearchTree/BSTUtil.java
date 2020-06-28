/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class BSTUtil<T extends Comparable<T>> {
	BinaryTreeNode<Integer> prev = null;
	int count = 0;
	public boolean isBST(BinarySearchTree<Integer> tree) {
		return isBST(tree.root);
	}
	
	private boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null)
			return true;
		else {
			boolean left = isBST(root.getLeft());
			if(!left)
				return left;
			if(prev != null && root.getData() <= prev.getData())
				return  false;
			prev  = root;
			return isBST(root.getRight());
				
		}
	}

	public Integer findKthSmallestElement(BinarySearchTree<Integer> tree, int k) {
		return findKthSmallestElement(tree.root, k).getData();
	}
	
	private BinaryTreeNode<Integer> findKthSmallestElement(BinaryTreeNode<Integer> root, int k) {
		if(root == null)
			return null;
		else {
			BinaryTreeNode<Integer> left = findKthSmallestElement(root.getLeft(), k);
			
			if(left != null)
				return left;
			count ++;
			if(count  ==k)
				return root;
			else
				return findKthSmallestElement(root.getRight(), k);
			
		}
	}
}
