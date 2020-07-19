package br.poli.view.console.state;

import br.poli.facade.SudokuFacade;

public abstract class WinLossState extends State {

	public WinLossState(SudokuFacade facade) {
		super(facade);
	}

	protected void printMessage() {
		System.out.print(MSG_INIT_OR_EXIT);
		this.facade.setActualPosition(sc.nextInt());
	}

	@Override
	public State nextState() {
		if (this.facade.getActualPosition() == 1) {
			return new InitialState(this.facade);
		}
		return new ExitState(this.facade);
	}
}
