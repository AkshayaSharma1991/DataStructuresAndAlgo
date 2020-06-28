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
public class WordCount {
	
	public static void main(String[] a) {
		String s = "geeks for geeks is a great site for geeks";
		count(s);
	}

	static void count(String a) {
		String[] s = a.split(" ");
		Map<String,Integer> wordMap = new HashMap<>();
		for(int i=0; i<s.length; i++) {
			if(wordMap.containsKey(s[i]))
				wordMap.put(s[i],wordMap.get(s[i]) + 1);
			else
				wordMap.put(s[i], 1);
		}
		
		Set<Entry<String,Integer>>  entries = wordMap.entrySet();
		
		int maxCount =0;
		String word ="";
		
		for(Entry<String,  Integer> entry: entries) {
			if(maxCount  < entry.getValue()) {
				maxCount = entry.getValue();
				word = entry.getKey();
			}
		}
		System.out.println("Max word: " + word + " count: " + maxCount);
	}
}
