/**
 * 
 */
package com.gfg.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		int[][] point = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int K = 2;
		int[][] closestPoints = closestPoints(point, K);
		System.out.println(closestPoints);
	}

	static int[][] closestPoints(int[][] point, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < point.length; i++) {
			int x = point[i][0];
			int y = point[i][1];
			Point p = new Point(x, y);
			p.distFromOrigin = Math.abs(x ^ 2 + y ^ 2);
			maxHeap.add(p);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		int[][] result = new int[k][2];
		int count = 0;
		while (maxHeap.size() > 0) {
			Point p = maxHeap.poll();
			result[count][0] = p.x;
			result[count][1] = p.y;
			count++;
		}

		return result;
	}
}

class Point implements Comparable<Point> {
	Integer distFromOrigin;
	Integer x;
	Integer y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point p) {
		return this.distFromOrigin.compareTo(p.distFromOrigin);
	}
}