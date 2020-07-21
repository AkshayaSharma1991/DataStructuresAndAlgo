/**
 * 
 */
package com.dsa.binaryTree;

import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class BinaryTree<T extends Comparable<T>> {
	public BinaryTreeNode<T> root;
	private int size;

	/**
	 * @return the root
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(T data) {
		BinaryTreeNode<T> node = new BinaryTreeNode<>();
		node.setData(data);
		if (root == null) {
			root = node;
		} else {
			Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>();
			queue.enqueue(root);

			while (!queue.isEmpty()) {
				BinaryTreeNode<T> currNode = queue.deQueue();
				if (currNode.getLeft() != null) {
					queue.enqueue(currNode.getLeft());
				} else {
					currNode.setLeft(node);
					break;
				}
				if (currNode.getRight() != null) {
					queue.enqueue(currNode.getRight());
				} else {
					currNode.setRight(node);
					break;
				}
			}
		}
		size++;
	}

	public void levelOrder() {
		if (root == null)
			return;
		else {
			Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>();
			queue.enqueue(root);
			System.out.print(" " + root.getData());
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> currNode = queue.deQueue();
				if (currNode.getLeft() != null) {
					System.out.print(" " + currNode.getLeft().getData());
					queue.enqueue(currNode.getLeft());
				} else {
					break;
				}
				if (currNode.getRight() != null) {
					System.out.print(" " + currNode.getRight().getData());
					queue.enqueue(currNode.getRight());
				} else {
					break;
				}
			}
		}
	}

	public void preOrderTraversal() {
		preOrder(root);
	}

	private void preOrder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		else {
			System.out.print(" " + root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void postOrderTraversal() {
		postOrder(root);
	}

	private void postOrder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		else {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(" " + root.getData());
		}
	}

	public void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		else {
			inOrder(root.getLeft());
			System.out.print(" " + root.getData());
			inOrder(root.getRight());
		}
	}

	public void printLeafNodes() {
		printLeaf(root);
	}

	private void printLeaf(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		else {
			if (isLeaf(root)) {
				System.out.print(" " + root.getData());
				return;
			} else {
				printLeaf(root.getLeft());
				printLeaf(root.getRight());
			}
		}
	}

	private boolean isLeaf(BinaryTreeNode<T> node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public void printBoundary() {
		printLeft(root);
		printLeafNodes();
		printRight(root.getRight());
	}

	public void printLeft(BinaryTreeNode<T> node) {
		if (node == null || isLeaf(node))
			return;
		else {
			System.out.print(" " + node.getData());
			printLeft(node.getLeft());
		}
	}

	public void printRight(BinaryTreeNode<T> node) {
		if (node == null || isLeaf(node))
			return;
		else {

			printRight(node.getRight());
			System.out.print(" " + node.getData());
		}
	}

	public void deleteTree() {
		deleteSubTree(root);
		root = null;
		size = 0;
	}

	private void deleteSubTree(BinaryTreeNode<T> root) {
		if (root == null || isLeaf(root))
			return;
		else {
			deleteSubTree(root.getLeft());
			deleteSubTree(root.getRight());

			root.setLeft(null);
			root.setRight(null);
		}
	}

	public void printMaxValue() {
		System.out.println("Max value: " + findMax(root));
	}

	// Use post order traversal
	private T findMax(BinaryTreeNode<T> root) {
		if (root == null)
			return null;

		else {
			T leftMax = findMax(root.getLeft());
			T rightMax = findMax(root.getRight());
			T data = root.getData();

			if (leftMax != null && data.compareTo(leftMax) < 0)
				data = leftMax;
			if (rightMax != null && data.compareTo(rightMax) < 0)
				data = rightMax;

			return data;
		}

	}

	public int getSize1() {
		return currentSize(root);
	}

	public int currentSize(BinaryTreeNode<T> root) {
		if (root == null) {
			return 0;
		} else {
			int leftSize = currentSize(root.getLeft());
			int rightSize = currentSize(root.getRight());

			return leftSize + rightSize + 1;
		}
	}

	public BinaryTree<T> copyTree() {
		BinaryTree<T> newTree = new BinaryTree<>();
		newTree.setRoot(copyTreeInternal(root));
		System.out.println("\n  Post  Order traversal of  new tree: ");
		postOrder(newTree.getRoot());
		return newTree;
	}

	private BinaryTreeNode<T> copyTreeInternal(BinaryTreeNode<T> root) {
		if (root == null)
			return null;
		else {
			BinaryTreeNode<T> node = new BinaryTreeNode<>();
			node.setData(root.getData());

			node.setLeft(copyTreeInternal(root.getLeft()));
			node.setRight(copyTreeInternal(root.getRight()));

			return node;
		}
	}
	
	
	public int getHeight() {
		return maxDepth(root);
	}
	
	private int maxDepth(BinaryTreeNode<T> root) {
		if(root == null)
			return 0;
		else {
			int lDepth = maxDepth(root.getLeft());
			int rDepth = maxDepth(root.getRight());
			
			if(lDepth > rDepth)
				return lDepth + 1;
			else
				return rDepth + 1;
		}
	}
	
	public void mirrorTree() {
		root = mirror(root);
	}
	
	private BinaryTreeNode<T> mirror(BinaryTreeNode<T> root){
		if(root == null)
			return root;
		else {
			BinaryTreeNode<T> left = mirror(root.getLeft());
			BinaryTreeNode<T> right = mirror(root.getRight());
			
			root.setRight(left);
			root.setLeft(right);
			
			return root;
		}
		
	}
	
	public boolean checkValue(T data) {
		return checkValue(root, data);
	}
	
	private boolean checkValue(BinaryTreeNode<T> n, T data) {
		if(n == null)
			return false;
		else if(n.getData().equals(data)) return true;
		else {
			boolean left  = checkValue(n.getLeft(), data);
			if(left) {
				return left;
			}
			boolean right = checkValue(n.getRight(), data);
			return right;
		}
	}
	
	public void printAncestors(T data) {
		printAncestor(root, data);
	}
	
	private boolean printAncestor(BinaryTreeNode<T> n, T data) {
		if(n == null)
			return false;
		else if(n.getData().equals(data)) return true;
		else {
			boolean left  = printAncestor(n.getLeft(), data);
			if(left) {
				System.out.print(" " + n.getData());
				return left;
			}
			boolean right = printAncestor(n.getRight(), data);
			if(right) {
				System.out.print(" " + n.getData());
			}
			return right;
		}
	}
	
	public int printLevel(T data) {
		return printLevel(root, data);
	}
	
	private int printLevel(BinaryTreeNode<T> n, T data) {
		if(n == null)
			return -1;
		else if(n.getData().equals(data)) return 0;
		else {
			int left = printLevel(n.getLeft(), data);
			if(left > -1)
				return left + 1;
			int right = printLevel(n.getRight(), data);
			if(right  > -1)
				return right + 1;
			else
				return -1;
		}
	}
}
