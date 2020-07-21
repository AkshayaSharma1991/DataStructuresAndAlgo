/**
 * 
 */
package com.gfg.dp.bottomUp;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class BoxStackingProblem {
	public static void main(String[] args) {

		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);

		System.out.println("The maximum possible " + "height of stack is " + maxStackHeight(arr, 4));
	}

	static int maxStackHeight(Box[] arr, int n) {
		Box[] rot = new Box[3 * n];
		for (int i = 0; i < n; i++) {
			Box b = arr[i];
			rot[3 * i] = new Box(b.h, Math.max(b.d, b.w), Math.min(b.d, b.w));
			rot[3 * i + 1] = new Box(b.w, Math.max(b.h, b.d), Math.min(b.h, b.d));
			rot[3 * i + 2] = new Box(b.d, Math.max(b.h, b.w), Math.min(b.h, b.w));
		}

		for (int i = 0; i < rot.length; i++) {
			rot[i].area = rot[i].d * rot[i].w;
		}

		Arrays.sort(rot);

		int count = 3 * n;
		int[] msh = new int[count];
		for (int i = 0; i < count; i++) {
			msh[i] = rot[i].h;
		}

		for (int i = 1; i < count; i++) {
			msh[i] = 0;
			Box box = rot[i];
			int val = 0;
			for (int j = 0; j < i; j++) {
				Box prev = rot[j];
				if (box.w < prev.w && box.d < prev.d) {
					val = Math.max(val, msh[j]);
				}
				msh[i] = val + box.h;
			}
		}
		int max = -1;
		for (int i = 0; i < count; i++) {
			max = Math.max(max, msh[i]);
		}
		return max;
	}

}

class Box implements Comparable<Box> {

	// h --> height, w --> width,
	// d --> depth
	int h, w, d, area;

	// for simplicity of solution,
	// always keep w <= d

	/* Constructor to initialise object */
	public Box(int h, int w, int d) {
		this.h = h;
		this.w = w;
		this.d = d;
	}

	/*
	 * To sort the box array on the basis of area in decreasing order of area
	 */
	@Override
	public int compareTo(Box o) {
		return o.area - this.area;
	}
}
