/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class PrintLCS {

	public static void main(String[] a) {
		String x = "Chennai";
		String y = "Chengalpet";

		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
	}

	static String lcs(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		StringBuilder sb = new StringBuilder();
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
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}

		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (t[i][j] == t[i - 1][j - 1] + 1) {
				sb.append(x[i - 1]);
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[i - 1][j])
					j--;
				else
					i--;
			}
		}

		return sb.reverse().toString();
	}

}
