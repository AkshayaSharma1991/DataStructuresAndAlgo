/**
 * 
 */
package com.interview.prep;

import java.util.*;

/**
 * @author akshayas
 *
 */
public class UniquePairWithSum {

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2, 45, 46, 46 };
		int target1 = 47;
		System.out.println(getUniquePairs(nums1, target1));
		System.out.println("-------------------------------");
		int[] nums2 = { 1, 1 };
		int target2 = 2;
		System.out.println(getUniquePairs(nums2, target2));
	}

	static int getUniquePairs(int[] num, int target) {
		Set<List<Integer>> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				int p = map.get(num[i]);
				set.add(Arrays.asList(num[p] < num[i] ? num[p] : num[i], num[i] < num[p] ? num[i] : num[p]));
			} else
				map.put(target - num[i], i);
		}

		return set.size();
	}
}
