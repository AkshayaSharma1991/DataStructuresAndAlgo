/**
 * 
 */
package com.gfg.string.solution;

/**
 * @author akshayas
 *
 */
public class ConsecutiveElements {

	public static void main(String[] args) {
		String s = "aababbccd";
		System.out.println(s+ " : "  + consecutiveElements(s, s.length()));
	}
	
	static String consecutiveElements(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n-1;i++) {
			if(s.charAt(i) != s.charAt(i+1))
				sb.append(s.charAt(i));
		}
		sb.append(s.charAt(n-1));
		return  sb.toString();
	}
}
