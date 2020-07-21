/**
 * 
 */
package com.gfg.dp.bottomUp;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}

	static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, lis[i]);
		}
		return max;
	}
}
