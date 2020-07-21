/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class CountStringsFormedWithConstraint {

	public static void main(String[] args) {
		 int n = 3; // Total number of characters  
	        int bCount = 1, cCount = 2; 
	        System.out.println(countStrings(n,bCount,cCount)); 
	}

	static int countStrings(int n, int bCount, int cCount) {
		int[][][] t = new int[n + 1][bCount + 1][cCount + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= bCount; j++) {
				for (int k = 0; k <= cCount; k++) {
					t[i][j][k] = -1;
				}
			}
		}
		return countStringsUtil(t, n, bCount, cCount);
	}

	private static int countStringsUtil(int[][][] t, int n, int bCount, int cCount) {
		if (bCount < 0 || cCount < 0)
			return 0;
		if (bCount == 0 && cCount == 0)
			return 1;
		if (n == 0)
			return 1;

		if (t[n][bCount][cCount] != -1)
			return t[n][bCount][cCount];

		int res = countStringsUtil(t, n - 1, bCount, cCount);
		res += countStringsUtil(t, n - 1, bCount - 1, cCount);
		res += countStringsUtil(t, n - 1, bCount, cCount - 1);
		return (t[n][bCount][cCount] = res);
	}
}
