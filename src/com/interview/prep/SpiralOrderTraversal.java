/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;
import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class SpiralOrderTraversal {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(7);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		

		printSprial(tree.getRoot());
	}

	static void printSprial(BinaryTreeNode<Integer> n) {
		if (n == null)
			return;

		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();

		s1.push(n);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				BinaryTreeNode<Integer> temp = s1.pop();
				System.out.print(" " + temp.getData());
				if (temp.getRight() != null)
					s2.push(temp.getRight());
				if (temp.getLeft() != null)
					s2.push(temp.getLeft());
			}

			while (!s2.isEmpty()) {
				BinaryTreeNode<Integer> temp = s2.pop();
				System.out.print(" " + temp.getData());
				if (temp.getLeft() != null)
					s1.push(temp.getLeft());
				if (temp.getRight() != null)
					s1.push(temp.getRight());
			}
		}
	}
}
