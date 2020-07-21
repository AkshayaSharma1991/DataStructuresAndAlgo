/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 *
 */
public class SortStack {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		System.out.println(s.peek());
		sort(s);
		System.out.println(s.peek());
	}

	static void sort(Stack s) {
		if (!s.isEmpty()) {
			int x = s.pop();
			sort(s);
			sortedInsert(x, s);
		}
	}

	static void sortedInsert(int x, Stack s) {
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		} else {
			int temp = s.pop();
			sortedInsert(x, s);
			s.push(temp);
		}
	}
}
