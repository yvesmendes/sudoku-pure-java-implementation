package br.poli.view;

import br.poli.facade.SudokuFacadeImpl;
import br.poli.view.console.state.State;
import br.poli.view.console.state.InitialState;

/**
 * State machine to control the game
 * @author yvesmendes
 *
 */
public class SudokuConsole {

	private State actualState;
	
	public SudokuConsole() {
		this.actualState = new InitialState(new SudokuFacadeImpl());
	}
	
	public void initiateProgram() {
		while (this.actualState.isActive()) {
			this.actualState.executeCommand();
			this.actualState = this.actualState.nextState();
		}
	}
}
