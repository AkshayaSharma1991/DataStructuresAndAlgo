/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 *
 */
public class EvaluatePostFix {

	public static void main(String[] args) {
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + evaluate(exp));
	}

	static int evaluate(String postFixExp) {
		char[] charArray = postFixExp.toCharArray();

		Stack stack = new Stack();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (Character.isDigit(c))
				stack.push(c - '0');
			else {
				int a = stack.pop();
				int b = stack.pop();
				int z = 0;
				switch (c) {
				case '+':
					z = b + a;
					stack.push(z);
					break;
					
				case '-':
					z = b - a;
					stack.push(z);
					break;
					
				case '*':
					z = b * a;
					stack.push(z);
					break;
					
				case '/':
					z = b / a;
					stack.push(z);
					break;
				}
			}
		}
		return stack.pop();
	}
}
