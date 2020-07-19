package br.poli.board.templatemethod;

import br.poli.model.Board;

/**
 * A easy implementation for a board game
 * @author yvesmendes
 *
 */
class EasyBoardGame extends Board {
	private static final int QUANTITY_BLANK_HOLES = 10;
	private static final int MAX_QUANTITY_ERRORS = 32;
	
	@Override
	public int getMaxQuantityErrors() {
		return QUANTITY_BLANK_HOLES;
	}

	@Override
	public int getBlankPositionOnGrid() {
		return MAX_QUANTITY_ERRORS;
	}
}
