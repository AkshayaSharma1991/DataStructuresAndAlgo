/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 *
 */
public class ValidSubstring {

	public static void main(String[] args) {
		String str = "()(()))))";
		System.out.println(getSubstringLength(str, str.length()));
	}

	static int getSubstringLength(String s, int n) {
		Stack stack = new Stack();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(')
				stack.push(i);
			else {
				stack.pop();
				if (!stack.isEmpty()) {
					max = Math.max(max, i-stack.peek());
				} else
					stack.push(i);
			}
		}
		return max;
	}
}
