/**
 * 
 */
package com.gfg.string.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author akshayas
 *
 */
public class ReverseString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		for (int i = 1; i <= cases ; i++) {
			String s = reader.readLine();
			String[] sArr =  s.split("\\.");
			StringBuffer sb = new StringBuffer();
			for(int j=sArr.length-1; j>=0;j--) {
				sb.append(sArr[j]+".");
			}
			System.out.println(sb.substring(0, sb.length()-1));
		}
	}
}
