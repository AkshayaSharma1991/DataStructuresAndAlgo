/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		reorderLogFiles(logs);
		System.out.println(logs);
	}

	static String[] reorderLogFiles(String[] logs) {
		List<String> letterList = new ArrayList<>();
		List<String> digitList = new ArrayList<>();
		for (String log : logs) {
			if (log.split(" ")[1].charAt(0) < 'a') {
				digitList.add(log);
			} else
				letterList.add(log);
		}

		Collections.sort(letterList, (log1, log2) -> {
			String[] s1 = log1.split(" ");
			String[] s2 = log2.split(" ");
			int len1 = s1.length;
			int len2 = s2.length;
			for (int i = 1; i < Math.min(len1, len2); i++) {
				if (!s1[i].equals(s2[i]))
					return s1[i].compareTo(s2[i]);
			}

			return s1[0].compareTo(s2[0]);
		});

		for (int i = 0; i < logs.length; i++) {
			if (i < letterList.size())
				logs[i] = letterList.get(i);
			else
				logs[i] = digitList.get(i - letterList.size());
		}
		return logs;
	}

}
