/**
 * 
 */
package com.dsa.doublylinkedlist;

/**
 * @author akshayas
 *
 */
public class Node<T> {
	
	private T data;
	private Node next;
	private Node prev;
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
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	/**
	 * @return the prev
	 */
	public Node<T> getPrev() {
		return prev;
	}
	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	

}
