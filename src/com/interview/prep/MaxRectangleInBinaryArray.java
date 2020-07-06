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
public class MaxRectangleInBinaryArray {

	public static void main(String[] args) {
		int A[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };
		int R = 4;
		int C = 4;
		System.out.println("Max rectangle  area: " + getMaxRectangleArea(A, R, C));
	}

	static int getMaxRectangleArea(int[][] arr, int m, int n) {
		int result = Integer.MIN_VALUE;
		int row[] = new int[n];

		for (int j = 0; j < n; j++) {
			row[j] = arr[0][j];
		}

		result = mah(row, n);
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0)
					row[j] = 0;
				else {
					row[j] = row[j] + arr[i][j];
				}
			}
			result = Math.max(result, mah(row, n));
		}
		return result;
	}

	static int mah(int[] arr, int n) {
		Stack<StackHolder> stack = new Stack<>();
		int[] right = new int[n];
		int[] left = new int[n];
		int[] width = new int[n];

		// NearestSmallerLeft
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty())
				left[i] = -1;
			else if (arr[i] > stack.peek().value)
				left[i] = stack.peek().index;
			else {
				while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
					stack.pop();
				}
				if (stack.isEmpty())
					left[i] = -1;
				else
					left[i] = stack.peek().index;
			}
			stack.push(new StackHolder(arr[i], i));
		}

		// NearestSmallerRight
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty())
				right[i] = n;
			else if (arr[i] > stack.peek().value)
				right[i] = stack.peek().index;
			else {
				while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
					stack.pop();
				}
				if (stack.isEmpty())
					right[i] = n;
				else
					right[i] = stack.peek().index;
			}
			stack.push(new StackHolder(arr[i], i));
		}

		Collections.reverse(Arrays.asList(right));

		int max_area = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			width[i] = right[i] - left[i] - 1;
			max_area = Math.max(max_area, arr[i] * width[i]);
		}

		return max_area;
	}
}
