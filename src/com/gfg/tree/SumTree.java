/**
 * 
 */
package com.gfg.tree;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class SumTree {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(10);
		tree.insert(-2);
		tree.insert(6);
		tree.insert(8);
		tree.insert(-4);
		tree.insert(7);
		tree.insert(5);

		tree.inOrderTraversal();
		System.out.println();
		constructSumTree(tree.root);
		tree.inOrderTraversal();
	}

	static void constructSumTree(BinaryTreeNode<Integer> root) {
		constructTreeUtil(root);
		
	}

	static SumNode constructTreeUtil(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		if (root.getLeft() == null && root.getRight() == null) {
			SumNode sm = new SumNode();
			sm.sum =  root.getData();
			sm.nodeData = 0;
			root.setData(0);
			return sm;
		}
		SumNode left = constructTreeUtil(root.getLeft());
		SumNode right = constructTreeUtil(root.getRight());
		SumNode sm = new SumNode();
		if (left != null && right != null) {
			sm.nodeData = root.getData();
			root.setData(left.nodeData + left.sum + right.nodeData + right.sum);
			sm.sum = left.sum + right.sum;
		} else if (left == null) {
			sm.nodeData = root.getData();
			root.setData(right.nodeData + right.sum);
			sm.sum = right.sum;
		} else if (right == null) {
			sm.nodeData = root.getData();
			root.setData(left.nodeData + left.sum);
			sm.sum = left.sum;
		}
		return sm;

	}

}

class SumNode {
	int sum;
	int nodeData;
}
