/**
 * 
 */
package com.dsa.binarySearchTree;

import com.dsa.binaryTree.BinaryTreeNode;

/**
 * @author akshayas
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	public BinaryTreeNode<T> root;
	public int size = 0;
	
	public void insert(T data) {
		insert(root, data);
	}
	
	private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T data){
		if(node == null) {
			BinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setData(data);
			if(root == null)
				root = newNode;
			size++;
			return newNode;
		}
		else {
			if(data.compareTo(node.getData())  == 1) {
				node.setRight(insert(node.getRight(), data));
			}
			else
				node.setLeft(insert(node.getLeft(), data));
			return node;
		}
	}
	
	public boolean search(T data) {
		return search(root, data);
	}
	
	private boolean search(BinaryTreeNode<T> node, T data){
		if(node  == null)
			return  false;
		else {
			if(node.getData().equals(data))
				return true;
			else {
				boolean right;
				if(data.compareTo(node.getData()) > 1) {
					return search(node.getRight(), data);
				}
				else
					return search(node.getLeft(), data);
			}
		}
	}
	public void delete(T data) {
		BinaryTreeNode<T> deletedNode = delete(root, data);
		if(deletedNode != null)
			size--;
	}
	
	public T findMax() {
		return  findMax(root).getData();
	}
	private BinaryTreeNode<T> delete(BinaryTreeNode<T> root, T data){
		if(root == null)
			return null;
		else if(data.compareTo(root.getData()) == -1)
			root.setLeft(delete(root.getLeft(), data));
		else if(data.compareTo(root.getData()) == 1)
			root.setRight(delete(root.getRight(), data));
		else {
			if(root.getLeft() != null && root.getRight()!=null) {
				BinaryTreeNode<T> maxLeft  = findMax(root.getLeft());
				root.setData(maxLeft.getData());
				root.setLeft(delete(root.getLeft(), maxLeft.getData()));
			}
			else if(root.getLeft()!=null) {
				return root.getLeft();
			}
			else if(root.getRight() != null) {
				return root.getRight();
			}
			else
				return  null;
		}
		return root;
	}
	
	private BinaryTreeNode<T> findMax(BinaryTreeNode<T> root){
		if(root == null)
			return  null;
		else {
			if(root.getRight() != null)
				return findMax(root.getRight());
			else
				return root;
		}
		
	}
	public T findMin() {
		return  findMin(root).getData();
	}
	private BinaryTreeNode<T> findMin(BinaryTreeNode<T> root){
		if(root == null)
			return null;
		else {
			if(root.getLeft() != null)
				return  findMin(root.getLeft());
			else
				return root;
		}
	}
	
	public void  inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private  void inOrderTraversal(BinaryTreeNode<T> root) {
		if(root  == null)
			return;
		else {
			inOrderTraversal(root.getLeft());
			System.out.println(root.getData());
			inOrderTraversal(root.getRight());
		}
	}
}
