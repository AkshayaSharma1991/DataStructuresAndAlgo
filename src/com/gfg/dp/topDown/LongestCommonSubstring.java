/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String x = "GeeksforGeeks";
		String y = "GeeksQuiz";

		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
	}

	static int lcs(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			t[0][j] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
					result  = Math.max(result, t[i][j]);
				}
				else
					t[i][j] = 0;

			}
		}
		return result;
	}
}
