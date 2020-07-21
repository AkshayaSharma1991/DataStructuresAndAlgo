/**
 * 
 */
package com.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class LongestSubArraySum {

	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }, k = 0;
		System.out.println(longestSubArray(arr, k));
	}

	static int longestSubArray(int[] arr, int sum) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, -1);
		int currSum = 0;
		int max_length = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];

			if (sumMap.containsKey(currSum - sum)) {
				max_length = Math.max(max_length, i - sumMap.get(currSum - sum));
			}

			sumMap.putIfAbsent(currSum, i);
		}
		return max_length;
	}
}
