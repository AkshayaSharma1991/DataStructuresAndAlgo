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
public class LevelWithMaxNodes {

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
		
		System.out.println("Level with max nodes: " + maxNodeCount(tree.getRoot()));
	}

	static int maxNodeCount(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		else {
			int max_node_count = Integer.MIN_VALUE;
			int level = 0;
			int maxLevel = -1;
			Queue<BinaryTreeNode<Integer>> q = new Queue<>();
			q.enqueue(root);

			while (true) {
				int nodeCount = q.getSize();
				if (nodeCount == 0)
					break;
				else {
					if (nodeCount > max_node_count) {
						max_node_count = nodeCount;
						maxLevel = level;
					}

					while (nodeCount > 0) {
						BinaryTreeNode<Integer> node = q.deQueue();
						if (node.getLeft() != null)
							q.enqueue(node.getLeft());
						if (node.getRight() != null)
							q.enqueue(node.getRight());

						nodeCount--;
					}
				}
				level++;
			}
			return maxLevel;
		}

	}

}
