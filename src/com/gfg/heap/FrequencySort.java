/**
 * 
 */
package com.gfg.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class FrequencySort {

	public static void main(String[] args) {
		int nums[] = {2, 5, 2, 8, 5, 6, 8, 8};
		frequencySort(nums, nums.length);
		System.out.println(nums);
	}

	static void frequencySort(int[] arr, int n) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
		}
		PriorityQueue<PairInt> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int curr : frequencyMap.keySet()) {
			minHeap.add(new PairInt(frequencyMap.get(curr), curr));
		}

		int count = 0;
		while (!minHeap.isEmpty()) {
			PairInt p = minHeap.poll();
			int i =  count;
			count  += p.first;
			int val  = p.second;
			for(;i<count;i++) {
				arr[i] = val;
			}
			
		}
	}
}
