/**
 * 
 */
package com.dsa.search;

/**
 * @author akshayas
 *
 */
public class BinarySearch {
	
	static int search(int[] a, int low, int high, int  data) {
		int mid = low + (high-low)/2;
		if(data == a[mid])
			return  mid;
		if(data > a[mid]) {
			return search(a, mid+1, high, data);
		}
		return  search(a, low, mid-1, data);
	}
	
	
	static int findPeak(int[] arr, int low, int high) {
		int mid = low + (high-low)/2;
		if(arr[mid-1] < arr[mid] && arr[mid]  <  arr[mid+1])
			return findPeak(arr, mid+1, high);
		else if(arr[mid+1] < arr[mid] && arr[mid] < arr[mid-1])
			return findPeak(arr, low, mid-1);
		
		return arr[mid];
	}
	
	static int findFirstOccurence(int[] arr, int low, int high, int data) {
		int mid = low + (high-low)/2;
		if(data  > arr[mid])
			return findFirstOccurence(arr, mid+1, high, data);
		else if(data < arr[mid])
			return findFirstOccurence(arr, low, mid-1, data);
		else if(data == arr[mid]) {
			if(arr[mid-1] < data)
				return mid;
			else 
				return findFirstOccurence(arr, low, mid-1, data);
		}
		return -1;
	}
	
	static int findLastOccurence(int[] arr, int low, int high, int data) {
		int mid = low + (high-low)/2;
		if(data  > arr[mid])
			return findLastOccurence(arr, mid+1, high, data);
		else if(data < arr[mid])
			return findLastOccurence(arr, low, mid-1, data);
		else if(data == arr[mid]) {
			if(arr[mid+1] > data)
				return mid;
			else 
				return findLastOccurence(arr, mid+1, high, data);
		}
		return -1;
	}

	static void findMinMax(int[] a, int left, int right, Pair p) {
		if(left == right) {
			if(p.max < a[left])
				p.max =  a[left];
			if(p.min > a[right])
				p.min = a[right];
			return;
		}
		if(right -  left ==1) {
			if(a[right] < a[left]) {
				if(p.min > a[right])
					p.min = a[right];
				if(p.max < a[left])
					p.max = a[left];
			}else {
				if(p.min > a[left])
					p.min = a[left];
				if(p.max < a[right])
					p.max = a[right];
			}
			return;
		}
		else {
			int mid = (left + right)/2;
			findMinMax(a, left, mid, p);
			findMinMax(a, mid+1, right, p);
			
		}
	}
}
