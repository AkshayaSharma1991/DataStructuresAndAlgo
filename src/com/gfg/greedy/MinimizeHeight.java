/**
 * 
 */
package com.gfg.greedy;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class MinimizeHeight {

	public static void main(String[] args) {
		int arr[] = {3, 16, 12, 9, 20}; 
        int n = 5; 
        int k = 3; 
  
        System.out.println("Max height difference = "
                + minimizeHeight(arr, n, k)); 
	}

	static int minimizeHeight(int[] arr, int n, int k) {
		Arrays.sort(arr);

		int min = arr[0];
		int max = arr[n - 1];

		if (max - min <= k)
			return max - min;
		int avg = (max - min) / 2;
		for (int i = 0; i < n; i++) {
			if (arr[i] > avg)
				arr[i] = arr[i] - k;
			else
				arr[i] = arr[i] + k;
		}

		Arrays.sort(arr);
		return arr[n - 1] - arr[0];

	}
}
