package br.poli.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Util class
 * @author yvesmendes
 */
public class SudokuUtil {
	public static final List<Integer> AVAILABLE_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	private static final String LINE_SEPARATOR = "line.separator";

	/**
	 * Verify if the informed value is between 1 and 9
	 * @param value
	 * @return
	 */
	public static boolean isValidMove(int value) {
		return AVAILABLE_NUMBERS.contains(value);
	}

	/**
	 * Format a board to print in a console
	 * @param grid Actual grid for the game
	 * @return
	 */
	public static String returnStringBoard(int[][] grid) {

		StringBuilder sb = new StringBuilder(System.getProperty(LINE_SEPARATOR));
		sb.append("    ");

		for (int i = BigDecimal.ZERO.intValue(); i < grid.length; i++) {
			sb.append("(" + i + ") ");
		}

		sb.append(System.getProperty(LINE_SEPARATOR));
		String valor = null;
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				sb.append("   |===.===.===|===.===.===|===.===.===|");
			} else {
				sb.append("   |---.---.---|---.---.---|---.---.---|");
			}
			sb.append(System.getProperty(LINE_SEPARATOR));
			sb.append("(" + i + ")");
			for (int z = 0; z < 9; z++) {
				sb.append("|");
				valor = grid[i][z] == 0 ? " " : String.valueOf(grid[i][z]);
				sb.append(" " + valor + " ");
			}
			sb.append("|");
			sb.append(System.getProperty(LINE_SEPARATOR));
		}
		sb.append("   |===.===.===|===.===.===|===.===.===|");

		return sb.toString();
	}
}
