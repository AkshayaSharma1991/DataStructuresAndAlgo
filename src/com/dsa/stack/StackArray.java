/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 * Implement Stack using array.  Following  operations:
 * 	1. Pop
 *  2. Peek
 *  3. Push
 *  4. isEmpty
 */
public class StackArray {
	private  int top, capacity;
	private int[] stack;
	
	public  StackArray(int c) {
		top=-1;
		capacity =  c;
		stack  = new  int[capacity];
	}
	
	public void  push(int data) {
		if(top+1 == capacity)
			System.out.println("Stack is full");
		else {
			stack[++top]=data;
			System.out.println("Pushed " +  data);
		}
	}
	
	public boolean isEmpty() {
		return  top ==-1;
	}
	public void  pop() {
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			int  data = stack[top--];
			System.out.println("Popped: " + data);
		}
	}
	
	public void peek() {
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			System.out.println("Peek returned:  " + stack[top]);
		}
	}
}
