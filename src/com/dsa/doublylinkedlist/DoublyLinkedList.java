/**
 * 
 */
package com.dsa.doublylinkedlist;

/**
 * @author akshayas
 *
 */
public class DoublyLinkedList<T> {
	
	private Node<T> head;
	private int size;
	private Node<T> tail;
	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
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
	/**
	 * @return the tail
	 */
	public Node<T> getTail() {
		return tail;
	}
	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	public void append(T data) {
		Node n = new Node<T>();
		n.setData(data);
		if(isEmpty()) {
			head = n;
			tail = n;
			size++;
			return;
		}else {
			Node temp  =  tail;
			n.setPrev(temp);
			temp.setNext(n);
			tail = n;
			size++;
		}
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void traverse() {
		if(isEmpty())
			System.out.println("List is empty");
		else {
			Node currNode = head;
			while(currNode != null) {
				System.out.print(currNode.getData() + " ");
				currNode = currNode.getNext();
			}
		}
	}
	
	public void printReverse() {
		if(isEmpty())
			System.out.println("List is empty");
		else {
			Node currNode = tail;
			while(currNode != null) {
				System.out.print(currNode.getData() + " ");
				currNode = currNode.getPrev();
			}
		}
	}

	public void delete(T data) {
		if(isEmpty())
			System.out.println("List is empty");
		else {
			Node<T> currNode = head;
			while(currNode != null) {
				if(currNode.getData().equals(data)) {
					currNode.getPrev().setNext(currNode.getNext());
					currNode.getNext().setPrev(currNode.getPrev());
					currNode.setNext(null);
					currNode.setPrev(null);
					return;
				}
				else
					currNode = currNode.getNext();
			}
		}
	}
}
