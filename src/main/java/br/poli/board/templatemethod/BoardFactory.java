package br.poli.board.templatemethod;

import br.poli.enums.GameDifficulty;
import br.poli.model.Board;

/**
 * A factory class to create Board Game
 * @author yvesmendes
 *
 */
public class BoardFactory {

	private static BoardFactory boardFactory;

	private BoardFactory() {

	}

	public static BoardFactory getInstance() {

		if (boardFactory == null) {
			boardFactory = new BoardFactory();
		}

		return boardFactory;
	}

	public Board createBoard(GameDifficulty gameDifficulty) {
		Board tabuleiro = null;
		switch (gameDifficulty) {
			case NORMAL:
				tabuleiro = new NormalBoardGame().generateBoard();
				break;
			case HARD:
				tabuleiro = new HardBoardGame().generateBoard();
				break;
			case EASY:
			default:
				tabuleiro = new EasyBoardGame().generateBoard();
				break;
		}
		return tabuleiro;
	}
}
