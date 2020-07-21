/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class ReplaceAll0With5 {

	public static void main(String[] args) {
		System.out.println(replace(10120)); 
	}

	static int replace(int n) {
		if (n == 0)
			return 5;
		return replaceRec(n);
	}

	static int replaceRec(int n) {
		if(n == 0)
			return 0;
		
		int digit =  n %10;
		if(digit ==0)
			digit =5;
		
		return  replaceRec(n/10)*10+digit;
	}
}
