/**
 * 
 */
package com.gfg.slidingwindow;

/**
 * @author akshayas
 *
 */
public class CountAnagramOccurences {

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.print(findOccurence(text, word));
	}

	static int findOccurence(String s, String word) {
		int N = s.length();
		int n = word.length();

		int[] count = new int[256];

		for (int i = 0; i < n; i++) {
			count[s.charAt(i)]++;
		}
		for (int i = 0; i < n; i++) {
			count[word.charAt(i)]--;
		}

		int res = 0;
		if (isCountZero(count))
			res++;
		for (int i = n; i < N; i++) {
			count[s.charAt(i)]--;
			count[s.charAt(i - n)]++;
			if (isCountZero(count))
				res++;
		}
		return res;
	}

	static boolean isCountZero(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}
}
