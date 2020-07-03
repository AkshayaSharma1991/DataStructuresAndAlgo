/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geeks", "geekser" };
		int n = arr.length;

		String ans = commonPrefix(arr, 0, n - 1);
		if (ans.length() != 0) {
			System.out.println("The longest common prefix is " + ans);
		} else {
			System.out.println("There is no common prefix");
		}
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static String commonPrefix(String[] arr, int low, int high) {
		if (low == high)
			return arr[low];
		if (high > low) {
			int mid = (high + low) / 2;

			String s1 = commonPrefix(arr, low, mid);
			String s2 = commonPrefix(arr, mid + 1, high);

			return commonPrefixUtil(s1, s2);
		}
		return null;
	}

	private static String commonPrefixUtil(String s1, String s2) {
		String result = "";
		int n1 = s1.length(), n2 = s2.length();

		for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
			if (s1.charAt(i) != s2.charAt(j))
				break;
			else
				result = result + s1.charAt(i);
		}
		return result;
	}
}
