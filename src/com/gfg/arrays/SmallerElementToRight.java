/**
 * 
 */
package com.gfg.arrays;

import java.util.Stack;

/**
 * @author akshayas
 *
 */
public class SmallerElementToRight {

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3}; 
        int n = arr.length; 
        smallerElementToRight(arr, n); 
	}
	
	static void smallerElementToRight(int[] arr,int n) {
		int[] smaller = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		for(int i=n-1;i>=0;i--) {
			if(arr[i] > stack.peek()) {
				smaller[i] = stack.peek();
			} else {
				while(!stack.isEmpty()  && stack.peek()>=arr[i])
					stack.pop();
				if(stack.size() >0)
					smaller[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		
		for(int i=0; i<n;i++) {
			System.out.print(smaller[i] + " ");
		}
	}
}
