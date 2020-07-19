package br.poli.facade;

import br.poli.enums.GameDifficulty;
import br.poli.exceptions.InvalidMoveException;
import br.poli.exceptions.InvalidValueException;
import br.poli.exceptions.UnsolvedException;

/**
 * A facade for the application
 * @author yvesmendes
 *
 */
public interface SudokuFacade {

	/**
	 * Return actual grid for the game
	 * @return
	 */
	int[][] getGrid();

	/**
	 * Return the player name
	 * @return
	 */
	String getPlayerName();

	/**
	 * Return the elapsed time for the game
	 * @return
	 */
	String getElapsedTime();

	/**
	 * Return the quantity of errors
	 * @return
	 */
	int getQuantityErrors();

	/**
	 * Return the final score
	 * @return
	 */
	int getScore();


	void makeMove(int posicaoX, int posicaoY, int valor) throws InvalidMoveException, InvalidValueException;

	void solveGame() throws UnsolvedException;

	boolean isWin();

	int getActualPosition();

	void init();

	void setActualPosition(int nextInt);

	boolean endGame();

	void create(String nomeJogador, int idade, GameDifficulty dificuldadePartida);
}
