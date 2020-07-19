package br.poli.board.templatemethod;

import br.poli.model.Board;

/**
 * A normal implementation for a board game
 * @author yvesmendes
 *
 */
class NormalBoardGame extends Board {

	private static final int QUANTITY_BLANK_HOLES = 40;
	private static final int MAX_QUANTITY_ERRORS = 5;
	
	@Override
	public int getMaxQuantityErrors() {
		return MAX_QUANTITY_ERRORS;
	}

	@Override
	public int getBlankPositionOnGrid() {
		return QUANTITY_BLANK_HOLES;
	}
}
