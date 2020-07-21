/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class MedianOfBST {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		System.out.println(findMedian(tree.root));

	}

	static int count(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> pre, current;

		int count = 0;
		if (root == null)
			return count;

		current = root;
		while (current != null) {
			if (current.left == null) {
				count++;
				current = current.right;
			} else {
				pre = current.left;
				while (pre.getRight() != null && pre.getRight() != current) {
					pre = pre.getRight();
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					count++;
					current = current.right;
				}
			}
		}
		return count;
	}

	static int findMedian(BinaryTreeNode<Integer> root) {
		int count = count(root);
		int currCount = 0;
		BinaryTreeNode<Integer> curr = root, pre = null, prev = null;
		while (curr != null) {
			if (curr.left == null) {
				currCount++;

				if (count % 2 != 0 && currCount == (count + 1) / 2) {
					return prev.getData();
				} else if (count % 2 == 0 && currCount == (count / 2) + 1) {
					return (prev.getData() + curr.getData()) / 2;
				}
				prev = curr;
				curr = curr.getRight();
			} else {
				pre = curr.left;
				while (pre.getRight() != null && pre.getRight() != curr) {
					pre = pre.getRight();
				}
				if (pre.getRight() == null) {
					pre.right = curr;
					curr = curr.left;
				} else if (pre.getRight() == curr) {
					pre.right=null;
					currCount++;
					prev = pre;
					if (count % 2 != 0 && currCount == (count + 1) / 2) {
						return curr.getData();
					} else if (count % 2 == 0 && currCount == (count / 2) + 1) {
						return (prev.getData() + curr.getData()) / 2;
					}
					prev = curr;
					curr = curr.getRight();
				}
			}
		}
		return -1;
	}
}
