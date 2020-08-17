/**
 * 
 */
package com.gfg.arrays;

import java.util.Arrays;

/**
 * @author akshayas
 * https://www.geeksforgeeks.org/element-1st-array-count-elements-less-equal-2nd-array/
 */
public class CountElements {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 7, 9 };
		int arr2[] = { 0, 1, 2, 1, 1, 4 };

		countElements(arr1, arr2, arr1.length, arr2.length);
	}

	static void countElements(int[] arr1, int[] arr2, int m, int n) {
		Arrays.sort(arr2);
		for (int i = 0; i < m; i++) {
			int index = getCount(arr2, n, arr1[i]);
			System.out.print(index + 1 + " ");
		}
	}

	static int getCount(int[] arr, int n, int k) {
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}
}
