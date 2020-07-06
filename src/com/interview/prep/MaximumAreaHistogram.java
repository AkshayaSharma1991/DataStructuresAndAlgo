/**
 * 
 */
package com.interview.prep;

import java.util.Arrays;
import java.util.Collections;

import com.dsa.genericLinkedList.Stack;

/**
 * @author akshayas
 *
 */
public class MaximumAreaHistogram {

	public static void main(String[] args) {
		int[] height = {2,3,3,2};
		System.out.println("Max area of histogram:" + mah(height,height.length));
	}
	
	static int mah(int[] height, int n) {
		Stack<StackHolder>  stack = new Stack<>();
		int[] right = new int[n];
		int[] left =  new int[n];
		int[] width = new int[n];
		
		for(int i=0; i<n;i++) {
			if(stack.isEmpty())
				left[i] = -1;
			else if(stack.peek().value < height[i]) {
				left[i] = stack.peek().index;
			}else {
				while(!stack.isEmpty() && stack.peek().value >= height[i]) {
					stack.pop();
				}if(stack.isEmpty())
					left[i] = -1;
				else if(stack.peek().value<height[i])
					left[i] = stack.peek().index;
			}
			
			stack.push(new StackHolder(height[i],  i));
			
		}
		
		for(int i=n-1; i>=0;i--) {
			if(stack.isEmpty())
				right[i] = n;
			else if(stack.peek().value < height[i]) {
				right[i] = stack.peek().index;
			}else {
				while(!stack.isEmpty() && stack.peek().value >= height[i]) {
					stack.pop();
				}if(stack.isEmpty())
					right[i] = n;
				else if(stack.peek().value<height[i])
					right[i] = stack.peek().index;
			}
			
			stack.push(new StackHolder(height[i],  i));
		}
 		Collections.reverse(Arrays.asList(right));
 		
 		for(int i=0; i< n; i++) {
 			width[i] = right[i]- left[i]-1;
 		}
 		
 		int[] area = new int[n];
 		int maxArea = Integer.MIN_VALUE;
 		
 		for(int i=0; i<n; i++) {
 			int areaVal = height[i]*width[i];
 			maxArea = Math.max(maxArea, areaVal);
 			area[i] = areaVal;
 		}
 		
		return maxArea;
	}
}
