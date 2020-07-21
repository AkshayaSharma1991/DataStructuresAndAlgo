/**
 * 
 */
package com.interview.prep;

import java.util.HashSet;
import java.util.Set;
import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class FindPairWithSumInBST {

	public static void main(String[] args) {
		int sum = 33;
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(8);
		tree.insert(12);
		tree.insert(16);
		tree.insert(25);
		tree.insert(10);

		findPair(tree, sum);
	}

	static void findPair(BinaryTree<Integer> bst, int sum) {
		pairSum(bst.getRoot(), new HashSet<Integer>(), sum);
	}

	static boolean pairSum(BinaryTreeNode<Integer> node, Set<Integer> valSet, int target) {
		if (node == null)
			return false;
		if (pairSum(node.getLeft(), valSet, target))
			return true;
		if (valSet.contains(target - node.getData())) {
			System.out.println(node.getData() + " " + (target - node.getData()));
			return true;
		} else
			valSet.add(node.getData());

		return pairSum(node.getRight(), valSet, target);
	}

}
