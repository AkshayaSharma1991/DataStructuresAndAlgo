/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class AddGreaterValuesToNode {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        tree.inOrderTraversal();
        convert(tree.root);
        tree.inOrderTraversal();
	}

	static void convert(BinaryTreeNode<Integer> root) {
		convertInternal(root, new Sum());
	}

	static void convertInternal(BinaryTreeNode<Integer> node, Sum sum) {
		if (node == null)
			return;

		convertInternal(node.getRight(), sum);
		sum.val = sum.val + node.getData();
		node.setData(sum.val);
		convertInternal(node.getLeft(), sum);
	}

}

class Sum {
	int val;
}
