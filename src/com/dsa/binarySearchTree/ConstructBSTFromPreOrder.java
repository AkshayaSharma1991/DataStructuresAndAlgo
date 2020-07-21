/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTree;
import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class ConstructBSTFromPreOrder {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		BinaryTreeNode<Integer> root = constructBST(pre, size);
		tree.root = root;
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.inOrderTraversal();
	}

	static BinaryTreeNode<Integer> constructBST(int[] pre, int size) {
		Index index = new Index();
		index.index = 0;
		return constructBSTUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	static BinaryTreeNode<Integer> constructBSTUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {
		if (preIndex.index > size)
			return null;
		BinaryTreeNode<Integer> root = null;
		if (key > min && key < max) {
			root = new BinaryTreeNode<Integer>(key);
			preIndex.index = preIndex.index + 1;
			if (preIndex.index < size) {
				root.left = constructBSTUtil(pre, preIndex, pre[preIndex.index], min, key, size);
				root.right = constructBSTUtil(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}

		return root;
	}
}

class Index {
	int index;
}
