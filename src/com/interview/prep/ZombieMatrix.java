/**
 * 
 */
package com.interview.prep;

import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class ZombieMatrix {
	public static int R = 4;
	public static int C = 5;

	public static void main(String[] args) {
		int zombieMatrix[][] = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(zombieAttack(zombieMatrix));
		int zombieMatrix1[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(zombieAttack(zombieMatrix1));
	}

	static int zombieAttack(int[][] zombieMatrix) {
		Queue<Holder> queue = new Queue<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (zombieMatrix[i][j] == 1) {
					Holder h = new Holder(0, i, j);
					queue.enqueue(h);
				}
			}
		}
		Holder h = null;
		if(queue.isEmpty())
			return -1;
		while (!queue.isEmpty()) {
			h = queue.deQueue();
			if (isValid(h.x, h.y + 1) && zombieMatrix[h.x][h.y + 1] == 0) {
				zombieMatrix[h.x][h.y + 1] = 1;
				Holder h1 = new Holder(h.time + 1, h.x, h.y + 1);
				queue.enqueue(h1);
			}
			if (isValid(h.x, h.y - 1) && zombieMatrix[h.x][h.y - 1] == 0) {
				zombieMatrix[h.x][h.y - 1] = 1;
				Holder h1 = new Holder(h.time + 1, h.x, h.y - 1);
				queue.enqueue(h1);
			}
			if (isValid(h.x - 1, h.y) && zombieMatrix[h.x - 1][h.y] == 0) {
				zombieMatrix[h.x - 1][h.y] = 1;
				Holder h1 = new Holder(h.time + 1, h.x - 1, h.y);
				queue.enqueue(h1);
			}
			if (isValid(h.x + 1, h.y) && zombieMatrix[h.x + 1][h.y] == 0) {
				zombieMatrix[h.x + 1][h.y] = 1;
				Holder h1 = new Holder(h.time + 1, h.x + 1, h.y);
				queue.enqueue(h1);
			}
		}
		return h.time;
	}

	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}
}
