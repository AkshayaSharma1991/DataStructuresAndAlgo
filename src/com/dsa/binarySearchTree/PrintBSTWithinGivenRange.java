/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class PrintBSTWithinGivenRange {

	static int counter, size;
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
		tree1.insert(17);
		tree1.insert(4);
		tree1.insert(18);
		tree1.insert(2);
		tree1.insert(9);
	
		size = tree1.size;
		printValues(tree1.root, 4, 24);
	}
	
	static void  printValues(BinaryTreeNode<Integer> root, int lRange, int rRange) {
		int[] a  = new int[size];
		counter  = 0;
		inOrder(root, a);
		
		for(int i=0; i<size; i++) {
			if(a[i]>=lRange && a[i]<=rRange)
				System.out.print(a[i] + " ");
		}
	}
	
	static void inOrder(BinaryTreeNode<Integer> root, int[] a) {
		if(root!=null) {
			inOrder(root.left,  a);
			
			a[counter] = root.getData();
			counter++;
			
			inOrder(root.right,a);
		}
	}
}
