/**
 * 
 */
package com.interview.prep;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class MinElementStackWithExtraSpace {

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

class  MinElementStack{
	Stack<Integer> stack =  new Stack<>();
	Stack<Integer> supportingStack =  new Stack<>();
	
	public void push(int data) {
		if(supportingStack.isEmpty() || supportingStack.peek()>data) {
			supportingStack.push(data);
		}
		stack.push(data);
	}
	
	public int pop() {
		if(!supportingStack.isEmpty() && supportingStack.peek() == stack.peek())
			supportingStack.pop();
		return stack.pop();
	}
	
	public int getMinElement() {
		return supportingStack.peek();
	}
	
}
