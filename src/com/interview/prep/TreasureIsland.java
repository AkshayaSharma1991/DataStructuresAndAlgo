/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class TreasureIsland {

	public static void main(String[] args) {
		char[][] island = new char[][] { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
				
		System.out.println("Steps: "  + totalSteps(island));
	}

	static int totalSteps(char[][] island) {
		int steps = 0;
		boolean[][] visited = new boolean[island.length][island[0].length];
		CoOrdinate coOrdinate = new CoOrdinate(0, 0);
		visited[0][0] = true;
		Queue<CoOrdinate> queue = new Queue<CoOrdinate>();
		queue.enqueue(coOrdinate);
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!queue.isEmpty()) {
			int size = queue.getSize();
			for (int i = 0; i < size; i++) {
				CoOrdinate c = queue.dequeue();
				if (island[c.x][c.y] == 'X')
					return steps;
				for (int[] dir : dirs) {
					int x = c.x + dir[0];
					int y = c.y + dir[1];

					if (x >= 0 && x < island.length && y >= 0 && y < island[0].length && island[x][y] != 'D'
							&& !visited[x][y]) {
						CoOrdinate c1 = new CoOrdinate(x, y);
						queue.enqueue(c1);
					}
				}

			}
			steps++;
		}
		return steps;
	}
}

class CoOrdinate {
	int x;
	int y;

	public CoOrdinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
