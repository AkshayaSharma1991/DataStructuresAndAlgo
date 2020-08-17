/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class LeadersInArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		int n = arr.length;
		printLeaders(arr, n);
	}

	static void printLeaders(int[] arr, int n) {
		int max = Integer.MIN_VALUE;

		for (int i = n - 1; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
				System.out.print(max + " ");
			}
		}
	}
}
