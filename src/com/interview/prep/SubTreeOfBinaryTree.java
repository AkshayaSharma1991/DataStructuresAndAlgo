/**
 * 
 */
package com.interview.prep;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class SubTreeOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(6);
		
		
		BinaryTree<Integer> subTree = new BinaryTree<>();
		subTree.insert(2);
		subTree.insert(4);
		subTree.insert(5);
		
		System.out.println("Is subtree: "  + isSubtree(tree.getRoot(), subTree.getRoot()));
	}

	static boolean isSubtree(BinaryTreeNode<Integer> T, BinaryTreeNode<Integer> S) {
		if(S == null)
			return true;
		if(T == null)
			return false;
		if(isIdentical(T, S))
			return true;
		
		return (isSubtree(T.getLeft(), S) || isSubtree(T.getRight(), S));
	}

	static boolean isIdentical(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
		if (n1 == null && n2 == null)
			return true;
		else if (n1 == null || n2 == null)
			return false;
		else {
			return (n1.getData() == n2.getData() && isIdentical(n1.getLeft(), n2.getLeft())
					&& isIdentical(n1.getRight(), n2.getRight()));
		}
	}
}
