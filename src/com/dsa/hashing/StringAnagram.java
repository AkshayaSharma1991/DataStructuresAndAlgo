/**
 * 
 */
package com.dsa.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class StringAnagram {

	public static void main(String[] args) {
		String s1 = "meat";
		String s2  = "teamm";
		System.out.println("Is anagram? " + isAnagram(s1, s2));
	}
	
	public static boolean isAnagram(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i=0; i<c1.length; i++) {
			if(charMap.containsKey(c1[i])) {
				charMap.put(c1[i], charMap.get(c1[i]) +1);
			}
			else
				charMap.put(c1[i], 1);
		}
		
		for(int i=0; i< c2.length; i++) {
			if(charMap.containsKey(c2[i])) {
				charMap.put(c2[i], charMap.get(c2[i]) -1);
			}
			else
				charMap.put(c2[i], 1);
		}
		
		Set<Entry<Character,Integer>> entries = charMap.entrySet();
		for(Entry<Character, Integer> entry: entries) {
			if(entry.getValue()!=0)
				return false;
		}
		return true;
	}
}
