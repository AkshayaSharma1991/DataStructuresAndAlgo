/**
 * 
 */
package com.gfg.dp.memoization;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class LongestCommonSubsequence {

	public static int[][] t = new int[1001][1001];

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		for (int[] row : t) {
			Arrays.fill(row, -1);
		}
		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
	}

	static int lcs(char[] x, char[] y, int m, int n) {
		if (n == 0 || m == 0)
			return 0;
		if (t[m][n] != -1)
			return t[m][n];
		else {
			int result = -1;
			if (x[m - 1] == y[n - 1])
				result = 1 + lcs(x, y, m - 1, n - 1);
			else {
				result = Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
			}
			t[m][n] = result;
			return result;
		}
	}
}
