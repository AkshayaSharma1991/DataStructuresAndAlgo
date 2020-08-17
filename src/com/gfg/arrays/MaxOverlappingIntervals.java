/**
 * 
 */
package com.gfg.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class MaxOverlappingIntervals {

	public static void main(String[] args) {
		Point[] points = new Point[4];
		points[0] = new Point(1, 8);
		points[1] = new Point(2, 5);
		points[2] = new Point(5, 6);
		points[3] = new Point(3, 7);
		System.out.println(maxIntervals(points));
	}

	static int maxIntervals(Point[] points) {
		Arrays.sort(points);
		int count = 1;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i+1; j < points.length; j++) {
				if (!(points[i].y >= points[j].x)) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		Integer y1 = y;
		return y1.compareTo(o.y);
	}

}