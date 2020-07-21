/**
 * 
 */
package com.dsa.stack;

import java.util.Stack;

/**
 * @author akshayas
 *
 */
public class CountReversals {

	public static void main(String[] args) {
		String expr = "}}{{";

		System.out.println(countReversals(expr, expr.length()));
	}

	static int countReversals(String s, int n) {
		if (n % 2 != 0)
			return -1;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '}' && !stack.isEmpty()) {
				if (stack.peek() == '{')
					stack.pop();
				else
					stack.push(c);
			} else
				stack.push(c);
		}

		int reduced_len = stack.size();
		int b = 0;
		for (int i = 0; i < reduced_len; i++) {
			if (stack.peek() == '{') {
				stack.pop();
				b++;
			}
		}
		return (reduced_len / 2 + b % 2);

	}
}
