/**
 * 
 */
package com.gfg.string.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author akshayas
 *
 */
public class AnagramPalindrome {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(s + " " + anagramPalindrome(s, s.length()));
		s = "geeksogeeks";
		System.out.println(s + " " + anagramPalindrome(s, s.length()));
	}

	static boolean anagramPalindrome(String s, int n) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
		}

		int single = 0;
		for (Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() == 1)
				single++;
			else if (entry.getValue() % 2 != 0) {
				if (single > 1)
					return false;
			}
		}
		if (single > 1)
			return false;
		return true;
	}
}
