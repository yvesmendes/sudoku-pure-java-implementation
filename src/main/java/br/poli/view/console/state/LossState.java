package br.poli.view.console.state;

import br.poli.exceptions.UnsolvedException;
import br.poli.facade.SudokuFacade;

public class LossState extends WinLossState {

	private static final String MSG_IMPOSSIBLE_TO_SOLVE = "Impossible to solve this game";

	public LossState(SudokuFacade facade) {
		super(facade);
	}

	@Override
	public void executeCommand() {
		System.out.println(MSG_LOSS);
		sc.nextLine();

		try {
			this.facade.solveGame();
			this.showBoard();
		} catch (UnsolvedException e) {
			System.out.println(MSG_IMPOSSIBLE_TO_SOLVE);
		}
		
		this.printMessage();
	}
}
