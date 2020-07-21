/**
 * 
 */
package com.dsa.binarySearchTree;

import java.util.Stack;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class MergeTwoBST {

	public static void main(String[] args) {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<>();
		t1.insert(3);
		t1.insert(1);
		t1.insert(5);

		BinarySearchTree<Integer> t2 = new BinarySearchTree<>();
		t2.insert(4);
		t2.insert(2);
		t2.insert(6);

		merge(t1, t2);
	}

	static void merge(BinarySearchTree<Integer> t1, BinarySearchTree<Integer> t2) {
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		BinaryTreeNode<Integer> current1 = t1.root;
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		BinaryTreeNode<Integer> current2 = t2.root;

		if (t1.size == 0) {
			t2.inOrderTraversal();
			return;
		}
		if (t2.size == 0) {
			t1.inOrderTraversal();
			return;
		}

		while (current1 != null || current2 != null || !s1.isEmpty() || !s2.isEmpty()) {
			if (current1 != null || current2 != null) {
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.getLeft();
				}
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.left;
				}
			} else {
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = s2.pop();
						current2.left = null;
						inorder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = s1.pop();
						current1.left = null;
						inorder(current1);
					}
					return;
				}
				current1 = s1.pop();
				current2 = s2.pop();
				if (current1.getData() < current2.getData()) {
					System.out.print(current1.getData() + "  ");
					current1 = current1.right;
					s2.push(current2);
					current2 = null;
				} else {
					System.out.print(current2.getData() + "  ");
					current2 = current2.right;
					s1.push(current1);
					current1 = null;
				}
			}

		}

	}

	static void inorder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.getData() + " ");
			inorder(root.right);
		}
	}
}