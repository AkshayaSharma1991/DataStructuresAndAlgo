/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class CountWaysToNthStair {
	public static void main(String[] args) {
		System.out.println(countWays(2));
	}
	
	static int countWays(int stairs) {
		int[] res = new int[stairs +1];
		res[0] = 1;
		res[1] =1;
		
		for(int i=2; i<=stairs; i++) {
			res[i] =  res[i-1] + res[i-2];
		}
		
		return res[stairs];
	}
}
