package br.poli.view.console.state;

import java.util.Scanner;

import br.poli.facade.SudokuFacade;
import br.poli.util.SudokuUtil;

public abstract class State {
	
	protected SudokuFacade facade;
	protected Scanner sc;
	protected static final String MSG_INVALID_MOVE = "Invalid Move! Please inform a valid move.";
	protected static final String MSG_GOODBYE = "You are exiting! cya!";
	protected static final String MSG_POSITION = "Inform the position %s: ";
	protected static final String MSG_INIT_OR_EXIT = "Digit 1 for initiate or 0 for exit: ";
	protected static final String MSG_LOSS = "You loss! Press any key to show the solved board";
	protected static final String MSG_WIN = "You win! Congratulations";
	
	public State(SudokuFacade facade) {
		this.sc = new Scanner(System.in);
		this.facade = facade;
	}

	/**
	 * Execute the command of the state
	 */
	public abstract void executeCommand();

	/**
	 * Return the next state of the actual state
	 * @return
	 */
	public abstract State nextState();

	/**
	 * Verify if the command is active
	 * @return
	 */
	public boolean isActive() {
		return true;
	}

	/**
	 * Print the board of the game
	 */
	protected void showBoard(){
		System.out.println(SudokuUtil.returnStringBoard(this.facade.getGrid()));
	}
}
