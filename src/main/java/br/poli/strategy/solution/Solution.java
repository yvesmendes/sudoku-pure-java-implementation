package br.poli.strategy.solution;

import br.poli.exceptions.UnsolvedException;

/**
 * Contract for the solve a grid
 * @author yvesmendes
 *
 */
public interface Solution {

	void solve(int[][] grid) throws UnsolvedException;
}
