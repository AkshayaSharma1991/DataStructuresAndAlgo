/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class MinNumOfCoins {

	public static void main(String[]  args) {
		int[] coins = {5, 7, 8, 9};
		int sum = 49;
		System.out.println(minCount(coins, sum, coins.length));
	}
	
	static int minCount(int[] arr, int sum, int n) {
		int t[][] = new int[n+1][sum+1];
		
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < sum + 1; j++) {
				t[i][j] = Integer.MAX_VALUE-1;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = 0;
			}
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=sum;j++) {
				if(arr[i-1]<=j) {
					t[i][j] = Math.min(1+ t[i][j-arr[i-1]], t[i-1][j]);
				}
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][sum];
	}
}
