/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class MaxNumberWithKSwaps {

	public static void main(String[] args) {
		String str = "129814999";
		int k = 4;

		String max = str;
		max = maxNum(str, k, max, 0);
		System.out.println(max);
	}

	static String maxNum(String s, int k, String max, int counter) {

		if (k == 0)
			return max;

		int n = s.length();
		char maxVal = s.charAt(counter);
		for (int j = counter + 1; j < n; j++) {
			if (s.charAt(j) > maxVal) {
				maxVal = s.charAt(j);
			}
		}
		if (maxVal != s.charAt(counter))
			--k;
		for (int j = counter; j < n; j++) {
			if (s.charAt(j) == maxVal) {
				s = swap(s, counter, j);

				if (Integer.valueOf(s) > Integer.valueOf(max)) {
					max = s;
				}
				max = maxNum(s, k, max, counter + 1);
				s = swap(s, j, counter);
			}
		}
		return max;
	}

	static String swap(String s, int x, int y) {
		char[] arr = s.toCharArray();
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return String.valueOf(arr);
	}
}
