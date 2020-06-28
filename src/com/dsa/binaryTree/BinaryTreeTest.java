/**
 * 
 */
package com.dsa.binaryTree;

/**
 * @author akshayas
 *
 */
public class BinaryTreeTest {

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
		System.out.println("Level order traversal:  ");
		tree.levelOrder();
		
		System.out.println("\nPre order traversal:  ");
		tree.preOrderTraversal();
		
		System.out.println("\nPost order traversal:  ");
		tree.postOrderTraversal();
		
		BinaryTree<Integer> tree1 = tree.copyTree();
		System.out.println("Print path to leaf");
		BinaryTreeUtil.printRouteToLeaf(tree);
		System.out.println("\nIn order traversal:  ");
		tree.inOrderTraversal();
		
		System.out.println("\nPrint leaves:");
		tree.printLeafNodes();
		
		System.out.println("\nPrint Boundary:");
		tree.printBoundary();
		System.out.println();
		tree.printMaxValue();
		
		tree.mirrorTree();
		BinaryTree<Integer> tree2 = tree.copyTree();
		
		System.out.println("\n Are two trees equal?" + BinaryTreeUtil.isEquals(tree, tree2));
		System.out.println("\n Are two trees mirrors?" + BinaryTreeUtil.isMirror(tree, tree1));
		System.out.println("\nIn order traversal:  ");
		tree.inOrderTraversal();
		System.out.println("\n Tree  size: " + tree.getSize1());
		System.out.println("Height of the tree:  "  + tree.getHeight());
		System.out.println("Is 15 available: " + tree.checkValue(15));
		System.out.println("Ancestors of 15: ");
		tree.printAncestors(15);
		
		System.out.println("\nLevel  of 15: " + tree.printLevel(15));
		tree.deleteTree();
		
		
		System.out.println("\nLevel order traversal:  ");
		tree.levelOrder();
		
		
	}
}
