/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class SequencePatternMatching {
	public static void main(String[] args) {
		String a= "AXY";
		String  b = "ACGXJDFKDY";
		System.out.println(isPatternMatch(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
	}
	
	static boolean isPatternMatch(char[] a,  char[] b ,int m,int n) {
		int t[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			t[i][0] = 0;
		}
		for(int i=0;i<=n; i++) {
			t[0][i] = 0;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i-1] == b[j-1]) {
					t[i][j] = 1+t[i-1][j-1];
				}else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		if(t[m][n] == m)
			return true;
		else
			return false;
	}
}
