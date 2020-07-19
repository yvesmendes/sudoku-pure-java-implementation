package br.poli.model;

import java.util.Random;

import br.poli.exceptions.InvalidMoveException;
import br.poli.exceptions.InvalidValueException;
import br.poli.exceptions.UnsolvedException;
import br.poli.strategy.solution.BruteForceSolution;
import br.poli.strategy.solution.Solution;
import br.poli.util.SudokuUtil;

/**
 * Domain class for a board
 * @author yvesmendes
 */
public abstract class Board {

	private static final int MIN_BOARD_VALUE = 0;
	private static final int INITIAL_VALUE = 0;
	private static final int INCREMENT_VALUE = 1;
	private static final int MAX_BOARD_VALUE = 9;
	private static final int MAX_VALID_BOARD_VALUE = 8;
	private static final int DEFAULT_HOLES_VALUES = 81;
	protected int[][] grid = new int[MAX_BOARD_VALUE][MAX_BOARD_VALUE];
	protected int[][] gridSolution = new int[MAX_BOARD_VALUE][MAX_BOARD_VALUE];
	private Solution solver = new BruteForceSolution();

	public Board generateBoard() {
		this.nextCell(INITIAL_VALUE, INITIAL_VALUE);
		this.fillSolutionGrid();
		this.makeHoles();
		return this;
	}
	
	public abstract int getMaxQuantityErrors();

	public abstract int getBlankPositionOnGrid();

	public boolean nextCell(int positionX, int positionY) {
		int nextX = positionX;
		int nextY = positionY;
		Integer[] toCheck = SudokuUtil.AVAILABLE_NUMBERS.toArray(new Integer[SudokuUtil.AVAILABLE_NUMBERS.size()]);
		Random r = new Random();
		int tmp = INITIAL_VALUE;
		int current = INITIAL_VALUE;
		int top = toCheck.length;

		for (int i = top - INCREMENT_VALUE; i > INITIAL_VALUE; i--) {
			current = r.nextInt(i);
			tmp = toCheck[current];
			toCheck[current] = toCheck[i];
			toCheck[i] = tmp;
		}

		for (int i = INITIAL_VALUE; i < toCheck.length; i++) {
			if (isLegalMove(positionX, positionY, toCheck[i], this.grid)) {
				this.grid[positionX][positionY] = toCheck[i];
				if (positionX == MAX_VALID_BOARD_VALUE) {
					if (positionY == MAX_VALID_BOARD_VALUE) {
						return true;
					} else {
						nextX = INITIAL_VALUE;
						nextY = positionY + INCREMENT_VALUE;
					}
				} else {
					nextX = positionX + INCREMENT_VALUE;
				}
				if (nextCell(nextX, nextY)) {
					return true;
				}
			}
		}
		this.grid[positionX][positionY] = INITIAL_VALUE;
		return false;
	}

	private boolean isLegalMove(int x, int y, int current, int[][] grid) {
		try{
			validateXPosition(x, current, grid);
			validateYPosition(y, current, grid);

			int cornerX = getCornerXValue(x);
			int cornerY = getCornerYValue(y);

			for (int i = cornerX; i < 10 && i < cornerX + 3; i++) {
				for (int j = cornerY; j < 10 && j < cornerY + 3; j++) {
					if (current == grid[i][j]) {
						return false;
					}
				}
			}
		}catch (InvalidMoveException e){
			return false;
		}

		return true;
	}

	private int getCornerYValue(int y) {
		int cornerY = INITIAL_VALUE;
		if (y > 2) {
			if (y > 5) {
				cornerY = 6;
			} else {
				cornerY = 3;
			}
		}
		return cornerY;
	}

	private int getCornerXValue(int x) {
		int cornerX = INITIAL_VALUE;
		if (x > 2) {
			if (x > 5) {
				cornerX = 6;
			} else {
				cornerX = 3;
			}
		}
		return cornerX;
	}

	private boolean validateXPosition(int x, int current, int[][] grid) throws InvalidMoveException {
		for (int i = INITIAL_VALUE; i < MAX_BOARD_VALUE; i++) {
			if (current == grid[x][i]) {
				throw new InvalidMoveException();
			}
		}
		return true;
	}

	private boolean validateYPosition(int y, int current, int[][] grid) throws InvalidMoveException {
		for (int i = INITIAL_VALUE; i < MAX_BOARD_VALUE; i++) {
			if (current == grid[i][y]) {
				throw new InvalidMoveException();
			}
		}
		return true;
	}

	private void fillSolutionGrid() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int z = 0; z < this.grid[i].length; z++) {
				this.gridSolution[i][z] = this.grid[i][z];
			}
		}
	}

	public void makeHoles() {
		double remainingSquares = DEFAULT_HOLES_VALUES;
		double remainingHoles = Double.valueOf(this.getBlankPositionOnGrid());

		for (int i = MIN_BOARD_VALUE; i < MAX_BOARD_VALUE; i++)
			for (int j = MIN_BOARD_VALUE; j < MAX_BOARD_VALUE; j++) {
				double holeChance = remainingHoles / remainingSquares;
				if (Math.random() <= holeChance) {
					this.grid[i][j] = MIN_BOARD_VALUE;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}

	public void makeMove(int posicaoX, int posicaoY, int valor)
			throws InvalidMoveException, InvalidValueException {
		this.validateMove(posicaoX, posicaoY, valor);
		this.grid[posicaoX][posicaoY] = valor;
	}

	private void validateMove(int posicaoX, int posicaoY, int valor)
			throws InvalidMoveException, InvalidValueException {
		if (!SudokuUtil.isValidMove(valor)) {
			throw new InvalidMoveException();
		}

		if (this.isInvalidPositions(posicaoX, posicaoY)) {
			throw new InvalidMoveException();
		}

		if (this.grid[posicaoX][posicaoY] != MIN_BOARD_VALUE) {
			throw new InvalidMoveException();
		}

		if (this.gridSolution[posicaoX][posicaoY] != valor) {
			throw new InvalidValueException();
		}
	}

	private boolean isInvalidPositions(int positionX, int positionY) {
		return positionX > MAX_VALID_BOARD_VALUE || positionY > MAX_VALID_BOARD_VALUE || positionX < MIN_BOARD_VALUE || positionY < MIN_BOARD_VALUE;
	}

	public int[][] getGrid() {
		return this.grid;
	}

	@Override
	public String toString() {
		return SudokuUtil.returnStringBoard(this.grid);
	}

	public void solveBoard() throws UnsolvedException {
		long timeBefore = System.nanoTime();
		this.solver.solve(this.grid);
		long timeAfter = System.nanoTime();
		System.out.println("Elapsed time: "+Long.valueOf(timeAfter - timeBefore));
	}
	
	public boolean isGridFull(){
		for(int i = INITIAL_VALUE; i < this.grid.length; i++){
			for(int z = INITIAL_VALUE; z < this.grid[i].length; z++){
				if(this.grid[i][z] == INITIAL_VALUE){
					return false;
				}
			}
		}
		
		return true;
	}
}
