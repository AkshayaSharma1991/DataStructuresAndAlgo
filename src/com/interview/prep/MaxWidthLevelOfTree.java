/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;
import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class MaxWidthLevelOfTree {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		
		System.out.println("Max width:" + getMaxWidth(tree.getRoot()));
	}

	static int getMaxWidth(BinaryTreeNode<Integer> node) {
		if (node == null)
			return 0;

		int max_width = 0;
		Queue<BinaryTreeNode<Integer>> q = new Queue<>();
		q.enqueue(node);

		while (true) {
			int count = q.getSize();
			if (count == 0)
				break;
			else {
				max_width = Math.max(max_width, count);
				while (count != 0) {
					BinaryTreeNode<Integer> n = q.deQueue();
					if (n.getLeft() != null)
						q.enqueue(n.getLeft());
					if (n.getRight() != null)
						q.enqueue(n.getRight());
					count--;
				}
			}
		}

		return max_width;
	}
}
