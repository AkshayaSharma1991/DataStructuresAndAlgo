/**
 * 
 */
package com.gfg.string.solution;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class LongestUniqueSubstring {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubstring(str, str.length());
		System.out.println("The length of " + "the longest non repeating character is " + len);
	}

	static int longestUniqueSubstring(String s, int n) {
		int res = 0;
		int[] lastIndex = new int[256];
		Arrays.fill(lastIndex, -1);
		int i = 0;
		for (int j = 0; j < n; j++) {
			i = Math.max(i, lastIndex[s.charAt(j)] + 1);
			res = Math.max(res, j - i + 1);
			lastIndex[s.charAt(j)] = j;
		}

		return res;
	}
}
