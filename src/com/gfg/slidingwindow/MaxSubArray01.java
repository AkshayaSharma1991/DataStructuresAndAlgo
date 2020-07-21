/**
 * 
 */
package com.gfg.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class MaxSubArray01 {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
		int n = arr.length;

		System.out.println(getArraySize(arr, n));
	}

	static int getArraySize(int[] arr, int n) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		int maxSize = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				arr[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxSize = i + 1;
			}

			if (sumMap.containsKey(sum + n)) {
				if (maxSize < i - sumMap.get(sum + n)) {
					maxSize = i - sumMap.get(sum + n);
				}
			}

			else {
				sumMap.put(sum + n, i);
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == -1)
				arr[i] = 0;
		}
		return maxSize;
	}
}
