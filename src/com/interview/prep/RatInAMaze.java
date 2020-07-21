/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class RatInAMaze {

	public final static int R = 4;
	public final static int C = 4;
	public static int N;

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		N = maze.length;
		solveMaze(maze);
	}

	static boolean solveMaze(int[][] maze) {
		int sol[][] = new int[N][N];
		if (!solveMazeUtil(maze, 0, 0, sol))
			return false;
		printSolution(sol);
		return true;
	}

	static void printSolution(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	static boolean isSafe(int[][] maze, int x, int y) {
		return (x < N && y < N && maze[x][y] == 1);
	}

	static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {

		if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;
			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
}
