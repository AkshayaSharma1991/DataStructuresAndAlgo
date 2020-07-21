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
public class CreateTreeFromPreOrderTraversal {

	public static void main(String[] args) {
		int pre[] = new int[] { 10, 30, 20, 5, 15 };
		char preLN[] = new char[] { 'N', 'N', 'L', 'L', 'L' };
		BinaryTree tree = new BinaryTree<>();
		tree.root=constructTree(pre, preLN, tree.root);
		tree.inOrderTraversal();
	}
	
	@SuppressWarnings("rawtypes")
	static BinaryTreeNode constructTree(int[] pre, char[] preLN, BinaryTreeNode node) {
		Index index = new Index();
		index.indexPtr = 0;
		return constructTreeUtil(pre, preLN, pre.length, index, node);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static BinaryTreeNode constructTreeUtil(int[] pre, char[] preLN, int n, Index index, BinaryTreeNode temp) {
		int currIndex = index.indexPtr;
		
		if(currIndex == n)
			return null;
		
		temp = new BinaryTreeNode<>();
		temp.setData(pre[currIndex]);
		index.indexPtr++;
		
		if(preLN[currIndex] == 'N') {
			temp.setLeft(constructTreeUtil(pre, preLN, n, index, temp.getLeft()));
			temp.setRight(constructTreeUtil(pre, preLN, n, index, temp.getRight()));
		}
		return temp;
	}
}

class Index {
	int indexPtr;
}
