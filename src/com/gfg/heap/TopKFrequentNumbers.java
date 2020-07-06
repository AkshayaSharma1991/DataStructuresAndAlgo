/**
 * 
 */
package com.gfg.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class TopKFrequentNumbers {

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3 }, k = 2;
		int[] vals = kFrequentNumbers(nums, nums.length, k);
		System.out.println(vals);
	}

	static int[] kFrequentNumbers(int[] arr, int n, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
		}
		PriorityQueue<PairInt> minHeap = new PriorityQueue<>();
		for (int curr : frequencyMap.keySet()) {
			minHeap.add(new PairInt(frequencyMap.get(curr), curr));
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		int[] frequentNumbers = new int[k];
		int count = 0;
		while (!minHeap.isEmpty()) {
			frequentNumbers[count] = minHeap.poll().second;
			count++;
		}
		return frequentNumbers;
	}
}
