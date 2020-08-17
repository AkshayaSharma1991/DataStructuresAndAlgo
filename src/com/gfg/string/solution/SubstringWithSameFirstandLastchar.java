/**
 * 
 */
package com.gfg.string.solution;

/**
 * @author akshayas
 *
 */
public class SubstringWithSameFirstandLastchar {

	public static void main(String[] args) {
		String s = "abcab"; 
        System.out.println(countSubstrings(s,s.length())); 
	}
	
	static int countSubstrings(String s, int n) {
		int result = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(s.charAt(i) == s.charAt(j)) {
					result++;
				}
			}
		}
		
		return result;
	}
}
