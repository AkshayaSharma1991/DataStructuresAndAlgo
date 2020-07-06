/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class PartitionLabels {

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		System.out.println(getPartitions(S));
	}

	static List<Integer> getPartitions(String s) {
		List<Integer> partitionLengths = new ArrayList<Integer>();
		int n = s.length();
		int[] lastIndexes = new int[26];

		for (int i = 0; i < n; i++) {
			lastIndexes[s.charAt(i) - 'a'] = i;
		}

		int i = 0;
		while (i < n) {
			int end = lastIndexes[s.charAt(i) - 'a'];
			int j = i + 1;
			while (j != end) {
				end = Math.max(end, lastIndexes[s.charAt(j++) - 'a']);
			}
			partitionLengths.add(j - i + 1);
			i = j + 1;
		}

		return partitionLengths;
	}
}
