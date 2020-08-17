/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class FindRepeatingElement {

	public static void main(String[] args) {
		int[] array = { 4, 2, 4, 5, 2, 3, 1 };
		int n = 5;

		repeatingElements(array, n);
	}

	static void repeatingElements(int[] arr, int n) {
		int[] count = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] == 1)
				System.out.print(arr[i] + " ");
			else
				count[arr[i]]++;
		}
	}
}
