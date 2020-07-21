/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class ReachGivenScore {
	
	public static void main(String[] args) {
		int[] points = {1,2};
		System.out.println(countWays(points, 4, 2));
	}
	
	static int countWays(int[] points, int score,  int n) {
		int[][] t= new int[n+1][score+1];
		
		for(int i=0;i<=score;i++) {
			t[0][i] = 0;
		}
		
		for(int i=0;i<=n; i++) {
			t[i][0] =  1;
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=score;j++) {
				if(points[i-1]<=j) {
					t[i][j]  = t[i-1][j] + t[i][j-points[i-1]];
				} else
					t[i][j]  = t[i-1][j];
			}
		}
		return t[n][score];
	}
}
