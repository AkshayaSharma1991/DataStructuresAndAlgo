/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class SortBinaryArray {

	public static void main(String[] args) {
		int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };

		int n = a.length;

		sortArray(a, n);

		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}

	static void sortArray(int[] arr, int n) {
		int j = -1;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 1) {
				j++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

}
