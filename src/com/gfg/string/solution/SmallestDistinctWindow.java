/**
 * 
 */
package com.gfg.string.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class SmallestDistinctWindow {
	public static void main(String[] args) {
		String s = "aabcbcdbca";
		String distinct = getDistinct(s);
		System.out.println(getWindow(s, distinct));
	}

	public static String getDistinct(String text) {
		Set<Character> distinct = new HashSet<>();
		for (int i = 0; i < text.length(); i++) {
			distinct.add(text.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for (char c : distinct) {
			sb.append(c);
		}
		return sb.toString();
	}

	static String getWindow(String text, String pattern) {
		int[] hash_text = new int[256];
		int[] hash_pat = new int[256];

		for (int i = 0; i < pattern.length(); i++) {
			hash_pat[pattern.charAt(i)]++;
		}
		int count = 0;
		int minWindow = Integer.MAX_VALUE;
		int first = -1;
		int start = 0;
		for (int j = 0; j < text.length(); j++) {
			hash_text[text.charAt(j)]++;
			if (hash_pat[text.charAt(j)] > 0 && hash_text[text.charAt(j)] <= hash_pat[text.charAt(j)]) {
				count++;
			}
			// All characters are found
			if (count == pattern.length()) {
				while (hash_pat[text.charAt(start)] == 0
						|| hash_pat[text.charAt(start)] < hash_text[text.charAt(start)]) {
					if (hash_pat[text.charAt(start)] < hash_text[text.charAt(start)]) {
						hash_text[text.charAt(start)]--;
					}
					start++;
				}
				int length = j - start + 1;
				if (minWindow > length) {
					minWindow = length;
					first = start;
				}
			}
		}
		if (first != -1)
			return text.substring(start, start + minWindow);
		return "";
	}
}
