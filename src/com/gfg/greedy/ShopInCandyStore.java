/**
 * 
 */
package com.gfg.greedy;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class ShopInCandyStore {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 4 };
		printCost(arr, arr.length, 2);
	}

	static void printCost(int[] arr, int n, int k) {
		Arrays.sort(arr);

		int minCost = 0;
		int low = 0, high = n - 1;

		while (low <= high) {
			minCost += arr[low];
			low++;
			high -= k;
		}

		System.out.println(minCost);
		int maxCost = 0;
		low = 0;
		high = n - 1;
		while (low <= high) {
			maxCost += arr[high];
			high--;
			low += k;
		}
		System.out.println(maxCost);
	}
}
