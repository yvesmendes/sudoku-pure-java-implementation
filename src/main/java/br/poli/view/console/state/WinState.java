package br.poli.view.console.state;

import br.poli.facade.SudokuFacade;

public class WinState extends WinLossState {

	public WinState(SudokuFacade facade) {
		super(facade);
	}

	@Override
	public void executeCommand() {
		System.out.println(MSG_WIN);
		System.out.println("Your score was: [" + this.facade.getPlayerName() + "] " + this.facade.getScore());
		this.printMessage();
	}
}
