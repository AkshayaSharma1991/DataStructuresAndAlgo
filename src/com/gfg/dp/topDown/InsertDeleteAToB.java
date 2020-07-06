/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class InsertDeleteAToB {

	public static void main(String[] args) {
		String str1 = "geeksforgeeks", str2 = "geeks";
		insertDeleteAToB(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
	}

	static void insertDeleteAToB(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1])
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
			}
		}

		int insertion = m - t[m][n];
		int deletion = n - t[m][n];
		System.out.println(insertion + " " + deletion);
	}
}
