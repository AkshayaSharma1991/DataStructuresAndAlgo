/**
 * 
 */
package com.dsa.genericLinkedList;

/**
 * @author akshayas
 *
 */
public class GenericNode<T> {
	
	private T data;
	public GenericNode<T> next;
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
	public GenericNode<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(GenericNode next) {
		this.next = next;
	}
	
	public GenericNode(T data) {
		this.data = data;
	}

}
