/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class UnboundedKnapsack {

	static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
		int[][] t = new int[n + 1][W + 1];
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j <= W; j++) {
				t[i][j] = 0;
			}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j) {
					t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
				} else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][W];
	}
	
	public static void main(String[] args) { 
        int W = 100; 
        int val[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int n = val.length; 
        System.out.println(unboundedKnapsack(wt, val, n, W)); 
    } 
}
