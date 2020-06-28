/**
 * 
 */
package com.dsa.bst.augmentedTree;

/**
 * @author akshayas
 *
 */
public class AugumentTreeTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AugmentedTree augTree = new AugmentedTree();
		augTree.insert(13);
		augTree.insert(2);
		augTree.insert(8);
		augTree.insert(10);
		augTree.insert(7);
		augTree.insert(15);
		augTree.insert(25);
	
		System.out.println("Inorder:");
		augTree.inOrder();
		
		augTree.delete(2);
		System.out.println("\nPreorder:");
		augTree.preOrder();
		
		System.out.println("\nPostOrder:");
		augTree.postOrder();
		
		System.out.println("\n3rd element in tree: " + augTree.search(3));
	}
}
