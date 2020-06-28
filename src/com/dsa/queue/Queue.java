/**
 * 
 */
package com.dsa.queue;

import com.dsa.genericLinkedList.GenericNode;
import com.dsa.linkedlist.single.Node;

/**
 * @author akshayas
 *
 */
public class Queue<T> {
	
	GenericNode<T>  front;
	GenericNode<T> rear;
	int size;
	
	public  void enqueue(T data) {
		GenericNode<T> newNode  =  new GenericNode<T>(data);
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			size++;
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
			size ++;
		}
			
	}
	
	public T deQueue() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return  null;
		}
		else {
			GenericNode<T> temp  = front;
			
			if(front == rear)
				front = rear = null;
			else {
				front = temp.getNext();
				temp.setNext(null);
			}
			size--;
			return temp.getData();
		}
	}

	public boolean isEmpty() {
		return  front == null && rear == null;
	}
	
	public int getSize() {
		return size;
	}
}
