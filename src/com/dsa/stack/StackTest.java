/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 *
 */
public class StackTest {
	
	public  static void main(String[] args) {
		Stack s = new  Stack();
		s.pop();
		s.push(5);
		s.push(6);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		
		StackArray s1= new StackArray(5);
		s1.push(5);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		s1.pop();
		s1.peek();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.peek();
	}

}
