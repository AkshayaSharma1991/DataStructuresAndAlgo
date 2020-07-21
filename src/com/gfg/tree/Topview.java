/**
 * 
 */
package com.gfg.tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;
import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class Topview {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode<Integer>(1);
		tree.root.left = new BinaryTreeNode<Integer>(2);
		tree.root.right = new BinaryTreeNode<Integer>(3);
		tree.root.left.right = new BinaryTreeNode<Integer>(4);
		tree.root.left.right.right = new BinaryTreeNode<Integer>(5);
		tree.root.left.right.right.right = new BinaryTreeNode<Integer>(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		printTopView(tree.root, 0);
	}

	static void printTopView(BinaryTreeNode<Integer> root, int hd) {
		if (root == null)
			return;
		Queue<QueueObj> queue = new Queue<>();
		Map<Integer, BinaryTreeNode<Integer>> hdMap = new TreeMap<Integer, BinaryTreeNode<Integer>>();
		queue.enqueue(new QueueObj(root, hd));

		while (!queue.isEmpty()) {
			QueueObj obj = queue.deQueue();
			if (!hdMap.containsKey(obj.hd)) {
				hdMap.put(obj.hd, obj.data);
			}
			if (obj.data.left != null) {
				queue.enqueue(new QueueObj(obj.data.left, obj.hd - 1));
			}
			if (obj.data.right != null) {
				queue.enqueue(new QueueObj(obj.data.right, obj.hd + 1));
			}
		}

		for (Entry<Integer, BinaryTreeNode<Integer>> entry : hdMap.entrySet()) {
			System.out.print(entry.getValue().getData() + " ");
		}
	}
}

class QueueObj {
	BinaryTreeNode<Integer> data;
	int hd;

	public QueueObj(BinaryTreeNode<Integer> data, int hd) {
		this.data = data;
		this.hd = hd;
	}
}
