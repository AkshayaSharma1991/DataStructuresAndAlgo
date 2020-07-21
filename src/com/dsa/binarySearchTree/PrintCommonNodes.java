/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class PrintCommonNodes {

	static int t1;
	static int t2;
	static int counter;

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
		tree1.insert(5);
		tree1.insert(1);
		tree1.insert(10);
		tree1.insert(0);
		tree1.insert(4);
		tree1.insert(7);
		tree1.insert(9);

		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.insert(10);
		tree2.insert(7);
		tree2.insert(20);
		tree2.insert(4);
		tree2.insert(9);

		t1 = tree1.size;
		t2 = tree2.size;

		printCommonNodes(tree1.root, tree2.root);

	}

	static void printCommonNodes(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
		int[] a = new int[t1];
		counter = 0;
		inOrder(n1, a);

		int[] b = new int[t2];
		counter = 0;
		inOrder(n2, b);

		printIntersection(a, b);
	}

	static void inOrder(BinaryTreeNode<Integer> n, int[] a1) {
		if (n != null) {
			inOrder(n.getLeft(), a1);

			a1[counter] = n.getData();
			counter++;

			inOrder(n.getRight(), a1);
		}
	}

	static void printIntersection(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;

		int i = 0, j = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}
	}
}
