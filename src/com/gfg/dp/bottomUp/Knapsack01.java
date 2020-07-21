/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class Knapsack01 {
	public static void main(String args[]) 
    { 
        int val[] = new int[] { 6, 10, 12 }; 
        int wt[] = new int[] { 1, 2, 3 }; 
        int W = 5; 
        int n = val.length; 
        System.out.println(knapSack(W, wt, val, n)); 
    } 
 
	static int knapSack(int W, int[] wt, int[] val, int n) {
		int[][] t  = new int[n+1][W+1];
		for(int i=0; i< n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}
		for(int i=1;  i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				if(wt[i-1] <= j) {
					t[i][j] =  Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				}else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][W];
	}
}
