/**
 * 
 */
package com.gfg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akshayas
 * 
 * https://www.geeksforgeeks.org/combinational-sum/
 *
 */
public class CombinationalSum {

	public static void main(String[] args) {
		int arr[] = {2,5,2,1,2};
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		combinationalSum(arr, 0, 5, new ArrayList<>(), result);
		System.out.println(result.size());
	}

	static void combinationalSum(int[] candidates, int index, int sum, List<Integer> current,
			List<List<Integer>> result) {
		if (sum == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		if (sum < 0)
			return;

		for (int i = index; i < candidates.length; i++) {
			if (i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				combinationalSum(candidates, i+1, sum - candidates[i], current, result);
				current.remove(current.size() - 1);
			}
		}
	}
}
