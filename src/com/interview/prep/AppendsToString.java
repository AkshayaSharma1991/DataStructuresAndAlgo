/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class AppendsToString {

	public static void main(String[] args) {
		String s = "a";
		System.out.println(s + " min appends: " + minAppends(s));
		s = "";
		System.out.println(s + " min appends: " + minAppends(s));
		s = "abc";
		System.out.println(s + " min appends: " + minAppends(s));
		s = "abedeee";
		System.out.println(s + " min appends: " + minAppends(s));
		s = "abedeba";
		System.out.println(s + " min appends: " + minAppends(s));
	}

	static int minAppends(String str) {
		int length = str.length();
		if (length == 0 || length == 1)
			return 0;
		int count = 0;
		int i = 0,j = length-1;
		for (; i < j;) {
			for (; j >=i;) {
				if(i==j)
					break;
				if (str.charAt(i) == str.charAt(j)) {
					i++;
					j--;
				} else {
					i++;
					count++;
				}
			}
		}
		return count;
	}
}
