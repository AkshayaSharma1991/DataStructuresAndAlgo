/**
 * 
 */
package com.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author akshayas
 *
 */
public class QueueReversal {

	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);

		reverseQueue();
		Print();
	}
	
	static void reverseQueue() {
		Stack<Integer> stack =  new Stack<Integer>();
		
		while(!queue.isEmpty()) {
			stack.add(queue.poll());
		}
		
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
	static void Print() {
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + " ");
			queue.remove();
		}
	}

}
