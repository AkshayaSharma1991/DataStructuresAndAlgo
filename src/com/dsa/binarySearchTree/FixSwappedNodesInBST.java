/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class FixSwappedNodesInBST {

	static BinaryTreeNode<Integer> prev, first, middle, last = null;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(6); 
        root.left = new BinaryTreeNode(10); 
        root.right = new BinaryTreeNode(2); 
        root.left.left = new BinaryTreeNode(1); 
        root.left.right = new BinaryTreeNode(3); 
        root.right.right = new BinaryTreeNode(12); 
        root.right.left = new BinaryTreeNode(7); 
  
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.root = root;
        bst.inOrderTraversal();
        fixSwappedNodes(root);
        bst.inOrderTraversal();
	}
	
	static void fixSwappedNodes(BinaryTreeNode<Integer> root) {
		fixUtil(root);
		if(first!=null && last!=null) {
			int temp = last.getData();
			last.setData(first.getData());
			first.setData(temp);
		}
		else  if(first!=null && middle!=null) {
			int temp = middle.getData();
			middle.setData(first.getData());
			first.setData(temp);
		}
	}
	
	static void fixUtil(BinaryTreeNode<Integer> node) {
		if(node!=null) {
			fixUtil(node.left);
			
			if(prev!=null && node.getData()<prev.getData()) {
				if(first == null) {
					first = prev;
					middle = node;
				}else {
					last = node;
				}
			}
			prev = node;
			fixUtil(node.right);
		}
	}
	
	
}
