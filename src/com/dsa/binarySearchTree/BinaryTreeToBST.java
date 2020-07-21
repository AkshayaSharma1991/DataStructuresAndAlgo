/**
 * 
 */
package com.dsa.binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class BinaryTreeToBST {

	static List<Integer> data = new ArrayList<>();

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(5);
		tree.insert(7);
		tree.insert(9);
		tree.insert(10);
		tree.insert(1);
		tree.insert(6);
		tree.insert(11);
		tree.inOrderTraversal();

		binaryTreeToSet(tree.getRoot());
		Collections.sort(data);
		setToBST(tree.getRoot());
		System.out.println();
		tree.inOrderTraversal();
	}

	static void binaryTreeToSet(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		binaryTreeToSet(root.getLeft());
		data.add(root.getData());
		binaryTreeToSet(root.getRight());
	}

	static void setToBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		setToBST(root.getLeft());
		root.setData(data.iterator().next());
		data.remove(root.getData());
		setToBST(root.getRight());
	}

}
