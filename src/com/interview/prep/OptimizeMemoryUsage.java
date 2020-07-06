/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class OptimizeMemoryUsage {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 7, 2, 4, 5, 6);
		List<Integer> b = Arrays.asList(1, 1, 2);

		List<int[]> solution = solution(a, b, 10);
		System.out.println(solution);
	}

	static List<int[]> solution(List<Integer> a, List<Integer> b, int target) {
		Map<Integer, List<int[]>> result = new HashMap<Integer, List<int[]>>();

		for (int i = 0; i < a.size(); i++) {
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[] { i, -1 });
			result.put(a.get(i), l);
		}

		for (int i = 0; i < b.size(); i++) {
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[] { -1, i });
			result.put(b.get(i), l);
		}

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				List<int[]> sum = result.getOrDefault(a.get(i) + b.get(j), new ArrayList<int[]>());
				sum.add(new int[] { i, j });
				result.put(a.get(i) + b.get(j), sum);
			}
		}

		List<Integer> allSum = new ArrayList<>();
		for (Integer i : result.keySet()) {
			if (i == target) {
				return result.get(i);
			} else if (i < target) {
				allSum.add(i);
			}
		}

		if (allSum.isEmpty())
			return new ArrayList<>();
		else
			return result.get(Collections.max(allSum));
	}
}
