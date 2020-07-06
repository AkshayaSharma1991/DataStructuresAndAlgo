/**
 * 
 */
package com.interview.prep;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class QueueUsingStack {

	public static void main(String[] ar) {
		Queue<Integer> q = new Queue<>();
		q.enqueue(1);
		q.enqueue(2);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}

class Queue<T> {
	private Stack<T> enqueueStack = new Stack<>();
	private  Stack<T> dequeueStack = new Stack<>();

	int getSize() {
		return enqueueStack.getSize() + dequeueStack.getSize();
	}

	boolean isEmpty() {
		return enqueueStack.isEmpty() && dequeueStack.isEmpty();
	}

	void enqueue(T data) {
		enqueueStack.push(data);
	}

	T dequeue() {
		if (isEmpty())
			return null;
		else {
			if (dequeueStack.isEmpty()) {
				while (enqueueStack.getSize() > 0) {
					dequeueStack.push(enqueueStack.pop());
				}
			}
			return dequeueStack.pop();
		}
	}
}
