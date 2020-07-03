/**
 * 
 */
package com.gfg.dp.memoization;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class Knapsack01 {
	
	 static int[][] t = new int[4][51];
	 public static void main(String args[]) 
	    { 
	        int val[] = new int[] { 60, 100, 120 }; 
	        int wt[] = new int[] { 10, 20, 30 }; 
	        int W = 50; 
	        int n = val.length; 
	        for(int[] row:t) {
	        		Arrays.fill(row, -1);
	        }
	        System.out.println(knapSack(W, wt, val, n)); 
	    } 
	 
	
	 static int knapSack(int  W, int[] wt, int[] val, int n) {
		 if(n==0 || W==0)
			 return 0;
		 if(t[n][W] != -1)
			 return t[n][W];
		 else {
			 int max_profit = 0;
			 if(wt[n-1] <= W) {
				 max_profit = Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
						 knapSack(W, wt, val, n-1));
				 
			 }else {
				 max_profit =  knapSack(W, wt, val, n-1);
			 }
			 
			 t[n][W] = max_profit;
			 return max_profit;
		 } 
	 }
}
