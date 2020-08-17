/**
 * 
 */
package com.gfg.string.solution;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class LargestSubstringWithKUniqueChars {

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		getSubstring(s, k);
	}

	static void getSubstring(String s, int k) {
		int[] count = new int[26];
		int u = 0;
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 0) {
				u++;
			}
			count[s.charAt(i) - 'a']++;
		}

		if (u < k) {
			System.out.println("Not available");
			return;
		}

		int curr_start = 0, curr_end = 0;
		int max_win_size = 1, max_win_start = 0;

		Arrays.fill(count, 0);
		count[s.charAt(0) - 'a']++;

		for (int i = 1; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			curr_end++;

			while (!isValid(count, k)) {
				count[s.charAt(curr_start) - 'a']--;
				curr_start++;
			}

			if (curr_end - curr_start + 1 > max_win_size) {
				max_win_size = curr_end - curr_start + 1;
				max_win_start = curr_start;
			}
		}
		System.out.println(
				"Max substring is : " + s.substring(max_win_start, max_win_start+max_win_size) + " with length " + max_win_size);
	}

	static boolean isValid(int[] count, int k) {
		int val = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0)
				val++;
		}
		return (k >= val);
	}
}
