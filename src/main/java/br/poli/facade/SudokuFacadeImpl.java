package br.poli.facade;

import br.poli.enums.GameDifficulty;
import br.poli.exceptions.InvalidMoveException;
import br.poli.exceptions.InvalidValueException;
import br.poli.exceptions.UnsolvedException;
import br.poli.model.Game;

/**
 * {@link SudokuFacade} default implementation
 * @author yvesmendes
 *
 */
public class SudokuFacadeImpl implements SudokuFacade {

	private Game game;

	@Override
	public void create(String playerName, int age, GameDifficulty gameDifficulty) {
		this.game = Game.createGame().withDifficulty(gameDifficulty).forPlayer(playerName, age);
	}

	@Override
	public void init() {
		game.init();
	}

	@Override
	public int[][] getGrid() {
		return game.getGrid();
	}

	@Override
	public String getPlayerName() {
		return game.getPlayerName();
	}

	@Override
	public String getElapsedTime() {
		return game.getElapsedTime();
	}

	@Override
	public int getQuantityErrors() {
		return game.getQuantityErrors();
	}

	@Override
	public int getScore() {
		return game.getScore();
	}

	@Override
	public void makeMove(int positionX, int positionY, int value)
			throws InvalidMoveException, InvalidValueException {
		game.executeMove(positionX, positionY, value);
	}

	@Override
	public void solveGame() throws UnsolvedException {
		game.solveBoard();
	}

	@Override
	public boolean isWin() {
		return game.isWin();
	}

	@Override
	public int getActualPosition() {
		return game.getActualPosition();
	}

	@Override
	public void setActualPosition(int nextInt) {
		this.game.setActualPosition(nextInt);
	}

	@Override
	public boolean endGame() {
		return !this.game.hasMove();
	}
}
