/**
 * 
 */
package com.gfg.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class CountDistinctInWindowK {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		countDistinctInWindow(arr, arr.length, k);
	}

	static int countDistinct(int[] arr, int start, int end) {
		Set<Integer> dist = new HashSet<>();
		for (int i = start; i <= end && i < arr.length; i++) {
			dist.add(arr[i]);
		}

		return dist.size();
	}

	static void countDistinctInWindow(int[] arr, int n, int k) {
		for (int i = 0; i < n; i++) {
			if (i >= k-1) {
				System.out.print(countDistinct(arr, i - k+1, i) + " ");
			}
		}
	}
}
