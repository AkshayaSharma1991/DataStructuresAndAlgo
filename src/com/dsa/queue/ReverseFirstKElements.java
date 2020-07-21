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
public class ReverseFirstKElements {

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

		int k = 5;
		reverseKElements(k);
		Print();
	}

	static void reverseKElements(int k) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < k; i++) {
			stack.add(queue.poll());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		for (int i = 0; i < queue.size() - k; i++) {
			queue.add(queue.poll());
		}
	}

	static void Print() {
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + " ");
			queue.remove();
		}
	}

}
