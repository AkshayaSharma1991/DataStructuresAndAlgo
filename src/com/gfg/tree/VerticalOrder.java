/**
 * 
 */
package com.gfg.tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class VerticalOrder {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		root.left = new BinaryTreeNode<Integer>(2);
		root.right = new BinaryTreeNode<Integer>(3);
		root.left.left = new BinaryTreeNode<Integer>(4);
		root.left.right = new BinaryTreeNode<Integer>(5);
		root.right.left = new BinaryTreeNode<Integer>(6);
		root.right.right = new BinaryTreeNode<Integer>(7);
		root.right.left.right = new BinaryTreeNode<Integer>(8);
		root.right.right.right = new BinaryTreeNode<Integer>(9);
		System.out.println("Vertical Order traversal is");
		printVerticalOrder(root);
	}

	static void printVerticalOrder(BinaryTreeNode<Integer> root) {
		Map<Integer, Vector<Integer>> map = new TreeMap<>();
		getVerticalOrder(root, 0, map);
		for (Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	static void getVerticalOrder(BinaryTreeNode<Integer> root, int hd, Map<Integer, Vector<Integer>> map) {
		if (root == null)
			return;
		Vector<Integer> entry = map.get(hd);
		if (entry == null) 
			entry = new Vector<>();
		entry.add(root.getData());
		map.put(hd, entry);
		getVerticalOrder(root.getLeft(), hd - 1, map);
		getVerticalOrder(root.getRight(), hd + 1, map);
	}
}
