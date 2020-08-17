/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class BuySellStock {

	public static void main(String[] args) {
		int [] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	
	static int maxProfit(int[] prices) {
		int n = prices.length;
		int diff = 0;
		int prev = prices[0];
		for(int i =1; i<n;i++) {
			if(prices[i]>prev) {
				diff += prices[i]-prev;
			}
			prev = prices[i];
		}
		return diff;
	}
}
