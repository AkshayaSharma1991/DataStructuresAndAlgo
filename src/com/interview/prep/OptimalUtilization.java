/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class OptimalUtilization {

	public static void main(String[] args) {
		List<int[]> a = new ArrayList<>();
		a.add(new int[] { 1, 3 });
		a.add(new int[] { 2, 5 });
		a.add(new int[] { 3, 7 });
		a.add(new int[] { 4, 10 });

		List<int[]> b = new ArrayList<>();
		b.add(new int[] { 1, 2 });
		b.add(new int[] { 2, 3 });
		b.add(new int[] { 3, 4 });
		b.add(new int[] { 4, 5 });

		List<int[]> result = solution(a, b, 10);
		System.out.println(result);
	}

	static List<int[]> solution(List<int[]> a, List<int[]> b, int target) {
		Map<Integer, List<int[]>> result = new HashMap<>();

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				List<int[]> sum = result.getOrDefault(a.get(i)[1] + b.get(j)[1], new ArrayList<>());
				sum.add(new int[] { a.get(i)[0], b.get(j)[0] });
				result.put(a.get(i)[1] + b.get(j)[1], sum);
			}
		}

		List<Integer> allSum = new ArrayList<>();
		for (Integer i : result.keySet()) {
			if (i == target) {
				return result.get(i);
			} else if (i < target)
				allSum.add(i);
		}

		if (allSum.isEmpty())
			return new ArrayList<>();
		else {
			return result.get(Collections.max(allSum));
		}
	}
}
