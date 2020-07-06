/**
 * 
 */
package com.interview.prep;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class BalancedParenthesis {

	public static void main(String[] args) {
		String exp = "[()]{}{[()()]()}";
		if(isBalanced(exp))
			System.out.println("Balanced");
		else
			System.out.println("Not balanced");
		
	}

	static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char c1 = stack.pop();
			switch (c) {
			case '}':
				if (c1 == '[' || c1 == '(')
					return false;
				break;
			case ']':
				if (c1 == '{' || c1 == '(')
					return false;
				break;
			case ')':
				if (c1 == '[' || c1 == '{')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
}
