/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class FindSmallestAndSecondSmallest {

	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		findNumbers(arr, arr.length);
	}

	static void findNumbers(int[] arr, int n) {
		int smallest = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] < smallest)
				smallest = arr[i];
			else if (arr[i] > smallest && arr[i] < second)
				second = arr[i];
		}

		System.out.println(smallest + " " + second);
	}
}
