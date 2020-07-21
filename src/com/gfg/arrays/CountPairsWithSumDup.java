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
public class CountPairsWithSumDup {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
		System.out.println("Count of pairs is " + countPairs(arr, arr.length, sum));
	}

	static int countPairs(int[] a, int n, int sum) {
		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			freqMap.put(a[i], freqMap.getOrDefault(a[i], 0) + 1);
		}

		int sumcount = 0;
		for (int i = 0; i < n; i++) {
			if (freqMap.containsKey(sum - a[i])) {
				sumcount += freqMap.get(sum - a[i]);
			}
			if (sum - a[i] == a[i]) {
				sumcount--;
			}
		}
		return sumcount / 2;
	}

}
