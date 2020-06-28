/**
 * 
 */
package com.dsa.binaryTree;

/**
 * @author akshayas
 *
 */
public class BinaryTreeUtil {

	@SuppressWarnings("rawtypes")
	public static boolean isEquals(BinaryTree tree1, BinaryTree tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		else {
			return isEquals(tree1.getRoot(), tree2.getRoot());
		}
	}

	@SuppressWarnings("rawtypes")
	private static boolean isEquals(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		else {
			if (isLeaf(node1) && isLeaf(node2)) {
				return node1.getData().equals(node2.getData());
			} else {
				if (node1.getData().equals(node2.getData())) {
					boolean left = isEquals(node1.getLeft(), node2.getLeft());
					if (!left)
						return left;
					boolean right = isEquals(node1.getRight(), node2.getRight());
					return right;
				}
				return false;
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static boolean isMirror(BinaryTree tree1, BinaryTree tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		else {
			return isMirror(tree1.getRoot(), tree2.getRoot());
		}
	}

	@SuppressWarnings("rawtypes")
	private static boolean isMirror(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		else {
			if (isLeaf(node1) && isLeaf(node2)) {
				return node1.getData().equals(node2.getData());
			} else {
				if (node1.getData().equals(node2.getData())) {
					boolean left = isMirror(node1.getLeft(), node2.getRight());
					if (!left)
						return left;
					boolean right = isMirror(node1.getRight(), node2.getLeft());
					return right;
				}
				return false;
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private static boolean isLeaf(BinaryTreeNode node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public static void printRouteToLeaf(BinaryTree tree) {
		printRouteToLeaf(tree.getRoot(), new int[tree.getHeight()], 0);
	}

	private static void printRouteToLeaf(BinaryTreeNode node, int[] route, int pathLen) {
		if (isLeaf(node)) {
			route[pathLen] = (Integer) node.getData();
			printArray(route, pathLen);
		} else {
			route[pathLen] = (Integer) node.getData();
			if (node.getLeft() != null)
				printRouteToLeaf(node.getLeft(), route, pathLen + 1);
			if (node.getRight() != null)
				printRouteToLeaf(node.getRight(), route, pathLen + 1);
		}

	}

	private static void printArray(int[] route, int pathLen) {
		System.out.println();
		for (int i = 0; i <= pathLen; i++) {
			System.out.print(" " + route[i]);
		}
	}
}
