/**
 * 
 */
package com.gfg.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author akshayas
 *
 */
public class SubArrayWithSum {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		
		for(int i=1; i<=cases*2; i+=2) {
			String s = reader.readLine();
			int arrLen = Integer.valueOf(s.split(" ")[0]);
			int sum = Integer.valueOf(s.split(" ")[1]);
			
			int[] arr = new int[arrLen];
			String s1= reader.readLine();
			String[] arrStr = s1.split(" ");
			for(int j =0; j< arrLen; j++) {
				arr[j] = Integer.valueOf(arrStr[j]);
			}
			subArrayWithSum(arr, sum);
		}
	}
	
	private static void subArrayWithSum(int[] arr, int sum) {
		int i=-1;
		boolean matched = false;
		while(i<arr.length-1  && !matched) {
			i++;
			int total  = arr[i];
			if(total == sum) {
				System.out.println((i+1)+" "  + (i+1));
				matched = true;
				break;
			}
			for(int j= i+1; j<arr.length; j++) {
				total = total+arr[j];
				if(total == sum) {
					System.out.println((i+1)+" "  + (j+1));
					matched = true;
					break;
				} else if(total > sum)
					break;
				else {
					
				}
			}
		}
		if(!matched)
			System.out.println(-1);
	}
}
