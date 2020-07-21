/**
 * 
 */
package com.gfg.greedy;

/**
 * @author akshayas
 *
 */
public class LargestNumberPossible {
	public static void main(String[] args) {
		int s = 20, m = 3; 
		largestPossibleNumber(s, m); 
	}
	
	static void largestPossibleNumber(int s, int m) {
		if(s  == 0)
			return;
		if(s > 9*m)
			return;
		int[] res = new int[m];
		
		for(int i=0; i<m;i++) {
			if(s>=9) {
				res[i] = 9;
				s = s-9;
			}
			else {
				res[i] = s;
				s=0;
			}
		}
		for(int i=0;i<m;i++) {
			System.out.print(res[i]);
		}
	}
}
