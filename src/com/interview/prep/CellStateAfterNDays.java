/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class CellStateAfterNDays {

	static void cellStateAfterNDays(int[] cellState, int days) {
		int[] newState = new int[cellState.length];
		for (int i = days; i > 0; i--) {
			for (int j = 0; j < cellState.length; j++) {
				int prev;
				int next;
				if (j == 0)
					prev = 0;
				else
					prev = cellState[j - 1];
				if (j == cellState.length - 1)
					next = 0;
				else
					next = cellState[j + 1];

				if (prev == next)
					newState[j] = 0;
				else
					newState[j] = 1;
			}
			cellState = newState.clone();
		}

		for (int i = 0; i < cellState.length; i++) {
			System.out.print(" " + cellState[i]);
		}
	}

	public static void main(String[] args) {
		int[] cellState = new int[] { 1, 1, 1, 0, 1, 1, 1, 1 };
		cellStateAfterNDays(cellState, 2);
	}
}
