package br.poli.view.console.state;

import br.poli.facade.SudokuFacade;

public class ExitState extends State {

	public ExitState(SudokuFacade facade) {
		super(facade);
	}

	@Override
	public void executeCommand() {
		System.out.println(MSG_GOODBYE);
		System.exit(1);
	}

	@Override
	public State nextState() {
		return null;
	}
}
