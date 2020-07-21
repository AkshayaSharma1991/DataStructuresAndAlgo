/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class MaxIntervalOverlap {

	public static void main(String[] args) {
		int arrl[] = { 1, 2, 10, 5, 5 };
		int exit[] = { 4, 5, 12, 9, 12 };
		int n = arrl.length;
		System.out.println(getMaxOverlap(arrl, exit, n));
	}

	static int getMaxOverlap(int[] arr, int[] exit, int n) {
		Arrays.sort(arr);
		Arrays.sort(exit);

		int max_guests = 1, guests_in = 1, time = arr[0];
		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] <= exit[j]) {
				guests_in++;
				if (guests_in > max_guests) {
					max_guests = guests_in;
					time = arr[i];
				}
				i++;
			} else {
				guests_in--;
				j++;
			}
		}

		return time;
	}
}
