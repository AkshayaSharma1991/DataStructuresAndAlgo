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
public class LevelWithMaxSum {

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
		tree.insert(3344);
		System.out.println("Level with max sum: " + maxSumLevel(tree.getRoot()) );
	}
	
	static int maxSumLevel(BinaryTreeNode<Integer> node) {
		if(node == null)
			return 0;
		else {
			int level = 0;
			int max_level = -1;
			int max_sum = Integer.MIN_VALUE;
			
			Queue<BinaryTreeNode<Integer>> q  = new Queue<>();
			q.enqueue(node);
			
			while(true) {
				int nodeCount = q.getSize();
				if(nodeCount  == 0)
					break;
				else {
					int sum  = 0;
					while(nodeCount > 0) {
						BinaryTreeNode<Integer> n = q.deQueue();
						sum  = sum + n.getData();
						if(n.getLeft()!=null)
							q.enqueue(n.getLeft());
						if(n.getRight()!=null)
							q.enqueue(n.getRight());
						
						nodeCount--;
					}
					if(sum>max_sum) {
						max_level = level;
						max_sum = sum;
					}
					level++;
				}
			}
			return max_level;
		}
	}
}
