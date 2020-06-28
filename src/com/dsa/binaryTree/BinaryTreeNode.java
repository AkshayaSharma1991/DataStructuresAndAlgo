/**
 * 
 */
package com.dsa.binaryTree;

/**
 * @author akshayas
 *
 */
public class BinaryTreeNode<T extends  Comparable<T>> {
	T  data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}
