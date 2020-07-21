/**
 * 
 */
package com.dsa.binarySearchTree;

import java.util.HashSet;
import java.util.Set;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class FindPairWithSum {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
		tree1.insert(15);
		tree1.insert(10);
		tree1.insert(20);
		tree1.insert(8);
		tree1.insert(9);
		tree1.insert(12);
		tree1.insert(16);
		tree1.insert(25);
		tree1.insert(10);

		findPair(tree1.root, 33);
	}

	static boolean findPair(BinaryTreeNode<Integer> root, int sum) {
		return findPairUtil(root, sum, new HashSet<>());
	}

	static boolean findPairUtil(BinaryTreeNode<Integer> root, int sum, Set<Integer> sumSet) {
		if (root != null) {
			if (sumSet.contains(sum - root.getData())) {
				System.out.println(root.getData() + " " + (sum - root.getData()));
				return true;
			} else {
				sumSet.add(root.getData());
				boolean left = findPairUtil(root.getLeft(), sum, sumSet);
				if (left)
					return left;
				return findPairUtil(root.getRight(), sum, sumSet);
			}
		}
		return false;
	}
}
