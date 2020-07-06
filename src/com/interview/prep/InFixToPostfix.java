/**
 * 
 */
package com.interview.prep;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas Rules: Priority ^ - 3 *,/ - 2 +,- - 1 Constraints: Two
 *         operators of same priority cannot stay together. A lower priority
 *         operator cannot be added before a higher priority operator. Operators
 *         between parenthesis need to be popped out once the closing
 *         parenthesis is encountered. Open and close parenthesis also popped
 *         out
 */
public class InFixToPostfix {

	static int prec(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		default:
			return -1;

		}
	}

	static String infixToPostfix(String s) {
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			// If char is letter of digit add to result
			if (Character.isLetterOrDigit(c)) {
				result += c;
			}

			// If char is open parenthesis push to stack
			else if (c == '(') {
				stack.push(c);
			}

			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid expression";
				else
					stack.pop();
			}

			else {
				while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
					if (stack.peek() == '(')
						return "Invalid expression";
					else
						result += stack.pop();
				}

				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek()=='(')
				return "Invalid expression";
			else
				result +=stack.pop();
		}
		return result;
	}
	
	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp)); 
	}
}
