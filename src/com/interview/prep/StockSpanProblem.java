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
 * Stock span approach:  Create a StockHolder.  for each price, 
 * compare the price with stack.peek.value, if stack value is 
 * greater than current price, add stack.peek.value to result array.  
 * Else, pop stack till stack.peek.value becomes greater 
 * than current  price, add stack.peek.value to result array.
 * 
 * Iterate through the result, print curr i - result[i]
 *
 */
public class StockSpanProblem {

	public static void main(String[] args) {
		int[] prices = {100, 80, 60, 70, 60, 75, 85};
		stockSpan(prices, prices.length);
	}

	static void stockSpan(int[] a, int n) {
		Stack<StackHolder> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				result.add(-1);
			} else if (stack.peek().value > a[i]) {
				result.add(stack.peek().index);
			} else {
				while (!stack.isEmpty() && stack.peek().value <= a[i]) {
					stack.pop();
				}
				if (stack.isEmpty())
					result.add(-1);
				else
					result.add(stack.peek().index);
			}
			stack.push(new StackHolder(a[i], i));
		}

		for (int i = 0; i < result.size(); i++) {
			int val = i - result.get(i);
			System.out.print(" " + val);
		}
	}
}

class StackHolder {
	int value;
	int index;

	public StackHolder(int value, int index) {
		this.value = value;
		this.index = index;
	}
}
