/**
 * 
 */
package com.interview.prep;

import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class RottenOranges {

	public final static int R = 3;
	public final static int C = 5;

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		System.out.println(rotOranges(arr));
	}

	static int rotOranges(int[][] arr) {
		Queue<Holder> queue = new Queue<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 2) {
					Holder h = new Holder(0, i, j);
					queue.enqueue(h);
				}
			}
		}
		Holder h = null;
		while (!queue.isEmpty()) {
			h = queue.deQueue();
			// Left
			if (isValid(h.x, h.y - 1) && arr[h.x][h.y - 1] == 1) {
				arr[h.x][h.y - 1] = 2;
				Holder h1 = new Holder(h.time + 1, h.x, h.y - 1);
				queue.enqueue(h1);
			}
			if (isValid(h.x, h.y + 1) && arr[h.x][h.y + 1] == 1) {
				arr[h.x][h.y + 1] = 2;
				Holder h1 = new Holder(h.time + 1, h.x, h.y + 1);
				queue.enqueue(h1);
			}
			if (isValid(h.x - 1, h.y) && arr[h.x - 1][h.y] == 1) {
				arr[h.x - 1][h.y] = 2;
				Holder h1 = new Holder(h.time + 1, h.x - 1, h.y);
				queue.enqueue(h1);
			}
			if (isValid(h.x + 1, h.y) && arr[h.x + 1][h.y] == 1) {
				arr[h.x + 1][h.y] = 2;
				Holder h1 = new Holder(h.time + 1, h.x + 1, h.y);
				queue.enqueue(h1);
			}

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 1)
					return -1;
			}
		}
		return h.time;
	}

	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}
}

class Holder {
	int time;
	int x;
	int y;

	public Holder(int time, int x, int y) {
		this.time = time;
		this.x = x;
		this.y = y;
	}
}
