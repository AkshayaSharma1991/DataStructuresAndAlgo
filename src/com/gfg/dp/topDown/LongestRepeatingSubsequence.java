/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String str = "AABEBCDD";
		System.out.println(lrs(str, str.length()));
	}

	static String lrs(String s, int n) {
		char[] s1 = s.toCharArray();
		char[] s2 = s.toCharArray();
		int t[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1[i - 1] == s2[j - 1] && i != j) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}
		int i = n, j = n;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (t[i][j] == t[i - 1][j - 1] + 1) {
				sb.append(s1[i - 1]);
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[j][i - 1])
					j--;
				else
					i--;
			}
		}
		return sb.reverse().toString();
	}
}
