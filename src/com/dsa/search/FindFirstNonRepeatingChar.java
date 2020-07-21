/**
 * 
 */
package com.dsa.search;

/**
 * @author akshayas
 *
 */
public class FindFirstNonRepeatingChar {

	static int[] count = new int[256];

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(firstChar(s));
	}

	static char firstChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] == 1)
				return s.charAt(i);
		}
		return '-';
	}
}
