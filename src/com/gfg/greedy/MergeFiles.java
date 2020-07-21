/**
 * 
 */
package com.gfg.greedy;

import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class MergeFiles {

	public static void main(String[] args) {
		// no of files
		int size = 6;

		// 6 files with their sizes
		int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
		System.out.println(optimalMerge(files));
	}

	static int optimalMerge(int[] files) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i : files) {
			minHeap.add(i);
		}

		int count = 0;
		while (minHeap.size() > 1) {
			int f1 = minHeap.remove();
			int f2 = minHeap.remove();

			int merge = f1 + f2;
			count += merge;
			minHeap.add(merge);
		}

		return count;
	}
}
