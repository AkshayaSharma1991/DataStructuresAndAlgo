/**
 * 
 */
package com.gfg.arrays;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
        rotateArray(arr, 7,2);
        System.out.println(Arrays.asList(arr));
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	static void rotateArray(int[] arr, int n, int d) {
		d = d%n;
		int i,j,k,temp;
		int gcd = gcd(d,n);
		for(i=0; i<gcd; i++) {
			temp = arr[i];
			j=i;
			while(true) {
				k = j+d;
				if(k>=n)
					k = k-n;
				if(k==i)
					break;
				arr[j] = arr[k];
				j=k;
			}
			arr[j] = temp;
		}
	}
}
