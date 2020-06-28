/**
 * 
 */
package com.dsa.hashing;

import java.util.HashSet;

/**
 * @author akshayas
 *
 */
public class PairEqualToSum {

	public static void main(String[] args) {
		int[] a  = new int[] {9,2,18,22,10,8,7,16,4};
		pairSum(a, 15);
		
	}
	
	static void pairSum(int[] a, int sum) {
		HashSet<Integer> pairs = new HashSet<>();
		for(int i =0; i<a.length; i++) {
			int diff = sum - a[i];
			boolean removed = pairs.remove(diff);
			if(removed) {
				System.out.println("(" + diff + "," + a[i]+")");
				break;
			}
			else
				pairs.add(a[i]);
		}
	}
}
