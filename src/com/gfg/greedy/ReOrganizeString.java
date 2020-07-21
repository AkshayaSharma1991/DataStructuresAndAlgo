/**
 * 
 */
package com.gfg.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class ReOrganizeString {

	public static void main(String[] args) {
		String s = "aaabbccc";
		System.out.println(reorganizeString(s, s.length()));
	}

	static String reorganizeString(String s, int n) {
		Map<Character, Integer> freq = new HashMap<>();
		char[] sArray = s.toCharArray();
		for (int i = 0; i < n; i++) {
			freq.put(sArray[i], freq.getOrDefault(sArray[i], 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

		for (Character c : freq.keySet()) {
			maxHeap.add(c);
		}
		StringBuilder sb = new StringBuilder();
		while (maxHeap.size() > 1) {
			char curr = maxHeap.remove();
			char next = maxHeap.remove();

			sb.append(curr).append(next);
			freq.put(curr, freq.get(curr) - 1);
			freq.put(next, freq.get(next) - 1);

			if (freq.get(curr) > 0)
				maxHeap.add(curr);
			if (freq.get(next) > 0)
				maxHeap.add(next);
		}

		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (freq.get(last) > 0)
				return "";
			sb.append(last);
		}

		return sb.toString();
	}
}
