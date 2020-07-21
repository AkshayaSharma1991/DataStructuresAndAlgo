/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class DistinctOccurenceSubsequence {

	public static void main(String[] args) {
		String T = "ge"; 
	    String S = "geeksforgeeks";
		System.out.println(distinctOccurence(S, T));
	}

	static int distinctOccurence(String s, String t) {
		int m = t.length();
		int n = s.length();

		int[][] mat = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			mat[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			mat[0][i] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (t.charAt(i - 1) != s.charAt(j - 1)) {
					mat[i][j] = mat[i][j - 1];
				} else {
					mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
				}
			}
		}
		return mat[m][n];
	}
}
