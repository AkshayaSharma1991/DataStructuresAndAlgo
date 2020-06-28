/**
 * 
 */
package com.dsa.bst.augmentedTree;

/**
 * @author akshayas
 *
 */
public class ATreeNode {
	
	private int data;
	private ATreeNode left;
	private ATreeNode right;
	private int size;
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public ATreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(ATreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public ATreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(ATreeNode right) {
		this.right = right;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	
}
