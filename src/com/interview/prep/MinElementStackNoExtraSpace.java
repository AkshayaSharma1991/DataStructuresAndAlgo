/**
 * 
 */
package com.interview.prep;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class MinElementStackNoExtraSpace {

	public static void main(String[] args) {
		MinElementStack s = new MinElementStack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.getMinElement());
		s.push(5);
		System.out.println(s.getMinElement());
	}
}

class SpaceEfficientMinimumElementStack {
	Stack<Integer> stack = new Stack<>();
	int minElement = -1;

	public void push(int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			minElement = data;
		} else if (data >= minElement) {
			stack.push(data);
		} else {
			stack.push(2 * data - minElement);
			minElement = data;
		}
	}

	public int pop() {
		if (stack.isEmpty())
			return -1;
		else if (stack.peek() >= minElement)
			return stack.pop();
		else {
			int data = minElement;
			minElement = 2 * minElement - this.top();
			return data;
		}
	}

	public int top() {
		if (stack.isEmpty())
			return -1;
		else if (stack.peek() >= minElement)
			return stack.peek();
		else {
			return minElement;
		}
	}
}
