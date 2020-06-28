/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeUtil;

/**
 * @author akshayas
 *
 */
public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.size);

		System.out.println("Is 30 available: " + tree.search(30));
		System.out.println("Max of tree:" + tree.findMax());
		System.out.println("Min of tree:" + tree.findMin());
		tree.delete(30);
		System.out.println(tree.size);

		System.out.println("Is 30 available: " + tree.search(30));
		BSTUtil<Integer> util = new BSTUtil<Integer>();
		System.out.println("Is binary tree:" + util.isBST(tree));
		System.out.println("\nInorder traversal: " );
		tree.inOrderTraversal();
		System.out.println("4th element in tree:" + util.findKthSmallestElement(tree, 4));
	}

}
