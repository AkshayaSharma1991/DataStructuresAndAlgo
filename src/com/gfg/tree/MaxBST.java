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
public class MaxBST {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(60);
		tree.insert(65);
		tree.insert(70);
		tree.insert(50);

		System.out.println(getMaxBST(tree.root).ans);
	}

	static Info getMaxBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}
		if (root.left == null && root.right == null) {
			return new Info(1, root.getData(), root.getData(), 1, true);
		}
		Info l = getMaxBST(root.getLeft());
		Info r = getMaxBST(root.getRight());

		Info res = new Info();
		res.size = 1 + l.size + r.size;

		if (l.isBST && r.isBST && l.max < root.getData() && r.min > root.getData()) {
			res.max = Math.max(l.max, Math.max(r.max, root.getData()));
			res.min = Math.min(l.min, Math.min(r.min, root.getData()));
			res.ans = res.size;
			res.isBST = true;
			return res;
		}
		res.ans = Math.max(l.ans, r.ans);
		res.isBST = false;
		return res;
	}
}

class Info {
	int size;
	int min;
	int max;
	int ans;
	boolean isBST;

	public Info() {

	}

	public Info(int size, int min, int max, int ans, boolean isBST) {
		this.size = size;
		this.max = max;
		this.min = min;
		this.ans = ans;
		this.isBST = isBST;
	}
}