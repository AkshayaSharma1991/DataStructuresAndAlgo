/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
	}
	
	static int lcs(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m;i++) {
			for(int j=0; j<=0; j++) {
				t[m][n] = 0;
			}
		}
		for(int i=0; i<=0;i++) {
			for(int j=0; j<=n; j++) {
				t[m][n] = 0;
			}
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1;j<=n;j++) {
				if(x[i-1] == y[j-1]) {
					t[i][j] = 1+t[i-1][j-1];
				}
				else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
				
			}
		}
		return t[m][n];
	}
}
