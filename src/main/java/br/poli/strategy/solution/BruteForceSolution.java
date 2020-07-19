package br.poli.strategy.solution;

import br.poli.exceptions.UnsolvedException;
import br.poli.util.SudokuUtil;

/**
 * A brute force implementation for {@link Solution}
 * @author yvesmendes
 *
 */
public class BruteForceSolution implements Solution {

	private static final int MIDDLE_VALUE = 3;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 9;

	public boolean solve(int row, int col, int[][] output) {

		if (output[row][col] != 0) {
			col++;
			if (col > 8) {
				row++;
				col = 0;
			}

			if (row >= output.length) {
				return true;
			}

			return solve(row, col, output);
		}

		for (Integer number : SudokuUtil.AVAILABLE_NUMBERS) {
			boolean invalidNumber = isValid(row, col, number, output);

			if (!invalidNumber) {
				continue;
			} else {
				output[row][col] = number;
				if (solve(row, col, output)) {
					return true;
				} else {
					output[row][col] = 0;
				}
			}
		}

		return false;
	}

	private boolean isValid(int row, int col, int number, int[][] output) {

		if (output[row][col] != MIN_VALUE) {
			throw new RuntimeException("Cannot call for cell which already has a value");
		}

		for (int y = MIN_VALUE; y < MAX_VALUE; y++) {
			if (number == output[row][y]) {
				return false;
			}
		}

		for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
			if (number == output[i][col]) {
				return false;
			}
		}

		int x1 = MIDDLE_VALUE * (row / MIDDLE_VALUE);
		int y1 = MIDDLE_VALUE * (col / MIDDLE_VALUE);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++) {
			for (int y = y1; y <= y2; y++) {
				if (output[x][y] == number) {
					return false;
				}
			}
		}

		return true;
	}

	public void solve(int[][] grid) throws UnsolvedException {
		this.solve(0, 0, grid);
	}
}
