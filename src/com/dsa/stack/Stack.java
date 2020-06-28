/**
 * 
 */
package com.dsa.stack;

import com.dsa.linkedlist.single.Node;

/**
 * @author akshayas
 *
 */
public class Stack {

	Node top;
	int size;

	public  void push(int data) {
		Node newNode = new Node(data);
		newNode.setNext(top);
		top = newNode;
		size++;
	}
	
	public  int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			Node temp  = top;
			top = temp.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
		}
	}
	
	public  int peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			Node temp  = top;
			return temp.getData();
		}
	}
	
	public  boolean isEmpty() {
		return top==null;
	}
	
	public  int getSize() {
		return size;
	}

}
