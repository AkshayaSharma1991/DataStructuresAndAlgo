/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "bbbab";
		System.out.println("LPS Count: " + lps(str, str.length()));
	}

	static int lps(String str, int n) {
		StringBuilder sb = new StringBuilder(str);
		char[] x = str.toCharArray();
		char[] y = sb.reverse().toString().toCharArray();

		int t[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1])
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
			}
		}
		return t[n][n];
	}
}
