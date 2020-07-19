package br.poli.board.templatemethod;

import br.poli.model.Board;

/**
 * A hard implementation for a board game
 * @author yvesmendes
 *
 */
class HardBoardGame extends Board {

	private static final int QUANTITY_BLANK_HOLES = 50;
	private static final int MAX_QUANTITY_ERRORS = 3;

	@Override
	public int getMaxQuantityErrors() {
		return MAX_QUANTITY_ERRORS;
	}

	@Override
	public int getBlankPositionOnGrid() {
		return QUANTITY_BLANK_HOLES;
	}
}
