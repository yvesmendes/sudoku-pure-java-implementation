package br.poli.model;

import br.poli.enums.GameDifficulty;
import br.poli.exceptions.InvalidMoveException;
import br.poli.exceptions.InvalidValueException;
import br.poli.exceptions.UnsolvedException;
import br.poli.strategy.score.CalculateScore;
import br.poli.strategy.score.CalculateScoreImpl;
import br.poli.board.templatemethod.BoardFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Domain class for a game
 */
public final class Game {

	private int quantityErrors = 0;
	private Player player;
	private Date time;
	private Board board;
	private GameDifficulty gameDifficulty = GameDifficulty.EASY;
	private int score = 0;
	private boolean win;
	private CalculateScore calculateScore;	
	private int actualPosition = 1;
	private static int SECONDS_ON_A_MINUTE = 60;
	private static String ELAPSED_TIME_FORMAT = "%02d:%02d";

	private Game() {
		this.calculateScore = new CalculateScoreImpl();
	}

	public static Game createGame() {
		return new Game();
	}

	public Game forPlayer(String nome, int idade) {
		this.player = new Player(nome, idade);
		return this;
	}

	public Game withDifficulty(GameDifficulty gameDifficulty) {
		this.gameDifficulty = gameDifficulty;
		return this;
	}

	public Game init() {

		if (this.player == null) {
			throw new IllegalArgumentException();
		}

		this.quantityErrors = 0;
		this.board = BoardFactory.getInstance().createBoard(this.gameDifficulty);
		this.time = new Date();
		this.win = false;

		return this;
	}

	public int[][] getGrid() {
		return this.board.getGrid();
	}

	public String getPlayerName() {
		return this.player.getName();
	}

	public String getElapsedTime() {
		long timeDiff = Math.abs(new Date().getTime() - this.time.getTime());
        return String.format(ELAPSED_TIME_FORMAT, calculateElapsedTime(timeDiff),
				TimeUnit.MILLISECONDS.toSeconds(timeDiff) % SECONDS_ON_A_MINUTE);
	}

	private long calculateElapsedTime(long timeDiff) {
		return TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff));
	}

	public int getQuantityErrors() {
		return this.quantityErrors;
	}

	public int getScore() {
		return this.score;
	}

	public void executeMove(int positionX, int positionY, int value) throws InvalidMoveException, InvalidValueException {
		try {
			this.board.makeMove(positionX, positionY, value);
			this.win = this.board.isGridFull();
			
			if(this.win){
				this.score = this.calculateScore.calculate(this.quantityErrors, this.time, this.gameDifficulty);
			}
		} catch (InvalidValueException e) {
			this.quantityErrors++;
			throw e;
		}
	}

	public boolean hasMove() {
		return this.getQuantityErrors() != this.board.getMaxQuantityErrors() && !this.win;
	}

	public void solveBoard() throws UnsolvedException {
		this.board.solveBoard();
	}

	public boolean isWin() {
		return this.win;
	}

	public int getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(int actualPosition) {
		this.actualPosition = actualPosition;
	}
}