/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 *https://www.geeksforgeeks.org/maximum-sum-lengths-non-overlapping-subarrays-k-max-element/
 */
public class SumOfLengthsOfSubArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 7, 1, 2, 9, 8, 4, 3, 1 };
		int size = arr.length;
		int k = 4;
		int ans = getCount(arr, size, k);
		System.out.println("Max Length :: " + ans);
	}

	static int getCount(int[] arr, int n, int k) {
		int ans = 0;
		int count = 0;
		int flag = 0;

		for (int i = 0; i < n;) {
			count = 0;
			flag = 0;

			while (i < n && arr[i] <= k) {
				count++;
				if (arr[i] == k) {
					flag = 1;
				}
				i++;
			}
			if (flag == 1)
				ans += count;

			while (i < n && arr[i] > k)
				i++;

		}

		return ans;
	}
}
