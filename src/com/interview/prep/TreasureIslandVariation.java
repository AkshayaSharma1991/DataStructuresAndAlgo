/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class TreasureIslandVariation {

	public static void main(String[] args) {
		char[][] grid1 = new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' },
				{ 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };

		char[][] grid2 = new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };

		System.out.println(totalSteps(grid1));
		System.out.println(totalSteps(grid2));
	}

	static int totalSteps(char[][] island) {
		int steps = 0;
		boolean[][] visited = new boolean[island.length][island[0].length];

		Queue<CoOrdinate> queue = new Queue<CoOrdinate>();
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[0].length; j++) {
				if (island[i][j] == 'S') {
					CoOrdinate c = new CoOrdinate(i, j);
					queue.enqueue(c);
				}
			}
		}
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
