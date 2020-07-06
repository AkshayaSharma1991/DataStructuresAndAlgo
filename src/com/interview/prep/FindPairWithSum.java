/**
 * 
 */
package com.interview.prep;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class FindPairWithSum {

	public static void main(String[] args) {
		int[] test = { 20, 50, 40, 25, 30, 10 };
		int target = 90;
		int[] result = pairWithSum(test, target);
		System.out.println(result);
	}

	static int[] pairWithSum(int[] arr, int target) {
		int[] result = { -1, -1 };
		int sum = target - 30;
		int largest = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - (sum - arr[i]));
			if (map.containsKey(arr[i]) && diff > largest) {
				largest = diff;
				result = new int[] { map.get(arr[i]), i };
			} else {
				map.put(sum - arr[i], i);
			}
		}

		return result;
	}
}
