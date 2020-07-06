/**
 * 
 */
package com.interview.prep;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class FindSubstringWithKUniqueChars {

	public static void main(String[] args) {
		String s = "aabab";
		int k = 3;
		System.out.println(countSubstring(s, k));
	}

	static int countSubstring(String s, int k) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + k; j <= s.length(); j++) {
				String temp = s.substring(i, j);
				int distinctCount = countDistinct(temp);
				if (distinctCount == k)
					count++;
				if (distinctCount > k)
					break;
			}
		}
		return count;
	}

	static int countDistinct(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size();
	}

}
