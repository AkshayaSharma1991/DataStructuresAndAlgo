/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.List;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class NearestSmallerToLeft {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };
		ngr(arr, arr.length);
	}

	static void ngr(int[] arr, int n) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				result.add(-1);
			} else if (stack.peek() < arr[i])
				result.add(stack.peek());

			else {
				while (stack.getSize() > 0 && stack.peek() >= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty())
					result.add(-1);
				else if (stack.peek() < arr[i])
					result.add(stack.peek());
			}
			stack.push(arr[i]);
		}
		//Collections.reverse(result);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(" " + result.get(i));
		}
	}
}
