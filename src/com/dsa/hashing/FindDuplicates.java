/**
 * 
 */
package com.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class FindDuplicates {

	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,1,1,4,3,3,2};
		findDuplicates(a);
	}
	
	static void findDuplicates(int[] a) {
		Map<Integer, Integer> elementMap= new HashMap<>();
		
		for(int i=0; i<a.length; i++) {
			if(elementMap.containsKey(a[i])) {
				int currentVal = elementMap.get(a[i]);
				if(currentVal ==1)
					System.out.print(" " + a[i]);
				elementMap.put(a[i], currentVal+1);
			}
			else {
				elementMap.put(a[i], 1);
			}
		}
		
	}
}
