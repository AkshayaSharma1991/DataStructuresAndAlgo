/**
 * 
 */
package com.interview.prep;

import com.dsa.hashing.StringAnagram;

/**
 * @author akshayas
 *
 */
public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		String s1 = "abckdfcbac";
		String s2 = "abc";
		getStartIndexOfAnagrams(s1, s2);

	}

	static void getStartIndexOfAnagrams(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		int[] result = new int[sLen - pLen];
		int count = -1;
		for (int i = 0; i <= sLen - pLen; i++) {
			String substring = s.substring(i, i + pLen);
			if (StringAnagram.isAnagram(substring, p)) {
				result[++count] = i;
			}

		}
		for (int i = 0; i <= count; i++) {
			System.out.print(" " + result[i]);
		}
	}
}
