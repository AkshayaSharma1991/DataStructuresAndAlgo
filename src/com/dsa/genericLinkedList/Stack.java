/**
 * 
 */
package com.dsa.genericLinkedList;


/**
 * @author akshayas
 *
 */
public class Stack<T> {

	GenericNode<T> top;
	int size;

	public void push(T data) {
		GenericNode<T> newNode = new GenericNode<T>(data);
		newNode.setNext(top);
		top = newNode;
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			GenericNode<T> temp = top;
			top = temp.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
		}
	}

	public T peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			GenericNode<T> temp = top;
			return temp.getData();
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int getSize() {
		return size;
	}

}
