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
public class BinaryTreeToCDLL {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		
		BinaryTreeNode head = buildCDLL(tree.getRoot());
		display(head);
	}

	// Display Circular Link List 
    @SuppressWarnings("rawtypes")
	static void display(BinaryTreeNode head) 
    { 
        System.out.println("Circular Linked List is :"); 
        BinaryTreeNode itr = head; 
        do
        { 
            System.out.print(itr.getData()+ " " ); 
            itr = itr.getRight(); 
        } 
        while (itr != head); 
        System.out.println(); 
    } 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static BinaryTreeNode buildCDLL(BinaryTreeNode node) {
		if(node == null)
			return null;
		BinaryTreeNode left = buildCDLL(node.getLeft());
		BinaryTreeNode right = buildCDLL(node.getRight());
		
		node.setLeft(node);
		node.setRight(node);
		
		return mergeList(mergeList(left, node), right);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static BinaryTreeNode mergeList(BinaryTreeNode leftList, BinaryTreeNode rightList) {
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;

		BinaryTreeNode leftEnd = leftList.getLeft();
		leftEnd.setRight(rightList);
		BinaryTreeNode rightEnd = rightList.getLeft();
		rightList.setLeft(leftEnd);

		leftList.setLeft(rightEnd);
		rightEnd.setRight(leftList);
		return leftList;
	}
}
