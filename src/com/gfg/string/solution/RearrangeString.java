/**
 * 
 */
package com.gfg.string.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class RearrangeString {

	public static void main(String[] args) {
		String s = "bbbbb";
		rearrangeString(s);
	}

	static void rearrangeString(String s) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
			return freq.get(b) - freq.get(a);
		});

		for (Entry<Character, Integer> entry : freq.entrySet()) {
			maxHeap.add(entry.getKey());
		}
		while (maxHeap.size() > 1) {
			char a = maxHeap.poll();
			char b = maxHeap.poll();

			int aFreq = freq.get(a);
			int bFreq = freq.get(b);

			if (aFreq - 1 > 0) {
				freq.put(a, aFreq - 1);
				maxHeap.add(a);
			}
			if (bFreq - 1 > 0) {
				freq.put(b, bFreq - 1);
				maxHeap.add(b);
			}

		}
		if (maxHeap.size() == 0) {
			System.out.println("1");
		} else {
			char remaining = maxHeap.poll();
			if (freq.get(remaining) == 1)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
