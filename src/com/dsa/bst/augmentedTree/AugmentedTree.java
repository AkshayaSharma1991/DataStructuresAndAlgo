/**
 * 
 */
package com.dsa.bst.augmentedTree;

/**
 * @author akshayas
 *
 */
public class AugmentedTree {
	
	private ATreeNode root;
	
	public void insert(int data) {
		root  = insert(root, data);
	}
	private ATreeNode insert(ATreeNode root, int data) {
		if(root == null) {
			ATreeNode node  = new ATreeNode();
			node.setData(data);
			node.setSize(1);
			root = node;
		}
		else {
			if(data<root.getData())
				root.setLeft(insert(root.getLeft(), data));
			else
				root.setRight(insert(root.getRight(), data));
		}
		root.setSize(size(root.getLeft()) + size(root.getRight()) + 1);
		return root;
	}

	private int size(ATreeNode root) {
		if(root == null)
			return 0;
		else
			return root.getSize();
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(ATreeNode root) {
		if(root == null)
			return;
		else {
			inOrder(root.getLeft());
			System.out.print(" "+root.getData() + " " +root.getSize() +";");
			inOrder(root.getRight());
		}
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(ATreeNode root) {
		if(root == null)
			return;
		else {
			System.out.print(" "+root.getData() + " " +root.getSize() +";");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(ATreeNode root) {
		if(root == null)
			return;
		else {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(" "+root.getData() + " " +root.getSize() +";");
		}
	}
	
	public int search (int k) {
		if(size(root) < k) {
			System.out.println("No matching elements found");
			return  0;
		}
		return search(root,k).getData();
	}
	
	private ATreeNode search(ATreeNode root, int k) {
		int r = size(root.getLeft()) + 1;
		if(k == r)
			return root;
		else if(k<r)
			return search(root.getLeft(), k);
		else
			return search(root.getRight(), k-r);
	}
	
	public void delete(int data) {
		root = delete(root, data);
	}
	private ATreeNode delete(ATreeNode root, int data) {
		if(root == null) {
			System.out.println("Data not found");
		}
		else if(data > root.getData())
			root.setRight(delete(root.getRight(), data));
		else if(data< root.getData())
			root.setLeft(delete(root.getLeft(), data));
		else {
			if(root.getLeft() != null && root.getRight() != null) {
				ATreeNode temp = findMax(root.getLeft());
				root.setData(temp.getData());
				root.setLeft(delete(root.getLeft(), root.getData()));
			}
			else if(root.getLeft() == null)
				root = root.getRight();
			else if(root.getRight() == null)
				root = root.getLeft();
			else
				root  = null;
		}
		
		if(root !=null)
			root.setSize(size(root.getLeft()) + size(root.getRight())  + 1);
		return root;
	}
	
	public ATreeNode findMax(ATreeNode root) {
		ATreeNode temp = root.getRight();
		while(temp != null) {
			temp = temp.getRight();
		}
		return temp;
	}
}
