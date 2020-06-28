/**
 * 
 */
package com.dsa.queue;

import com.dsa.stack.Stack;

/**
 * @author akshayas
 *
 */
public class QueueUsingStack {
	
	Stack enqueueStack;
	Stack dequeueStack;
	
	public boolean isEmpty() {
		return  enqueueStack.isEmpty()  && dequeueStack.isEmpty();
	}
	
	public int getSize() {
		return enqueueStack.getSize() +  dequeueStack.getSize();
	}
	
	public void enqueue(int data) {
		enqueueStack.push(data);
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		else {
			if(dequeueStack.isEmpty()) {
				while(!enqueueStack.isEmpty()) {
					dequeueStack.push(enqueueStack.pop());
				}
			}
			int  data  = dequeueStack.pop();
			return  data;
		}
	}

}
