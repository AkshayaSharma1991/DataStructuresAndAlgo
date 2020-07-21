/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class NumberOfSubsequenceABC {

	public static void main(String[] args) {
		String s = "abcabc";
		System.out.println(numberOfSubsequence(s));
	}
	
	static int numberOfSubsequence(String s) {
		int aCount =  0, bCount = 0,  cCount = 0;
		
		char[] charArray = s.toCharArray();
		
		for(char c:charArray) {
			if(c=='a')
				aCount = 1+ (2*aCount);
			else if(c=='b')
				bCount = aCount + (2*bCount);
			else
				cCount = bCount  + (2*cCount);
				
		}
		return cCount;
	}
}
