/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int ar1[] = {1, 12, 15, 26, 38}; 
        int ar2[] = {2, 13, 17, 30, 45}; 
        
        System.out.println(getMedian(ar1, ar2, ar1.length));
	}
	
	static int getMedian(int[] arr1, int[] arr2, int n) {
		int i=0,j=0;
		int m1=-1,m2=-1;
		int count = 0;
		
		for(;count<=n;count++) {
			if(i==n) {
				m1 = m2;
				m2 = arr2[0];
				break;
			}
			
			else if(j ==n) {
				m1=m2;
				m2 = arr1[0];
				break;
			}
			
			if(arr1[i]<arr2[j]) {
				m1=m2;
				m2 = arr1[i];
				i++;
			} else {
				m1=m2;
				m2 = arr2[j];
				j++;
			}
		}
		
		return (m1+m2)/2;
	}
}
