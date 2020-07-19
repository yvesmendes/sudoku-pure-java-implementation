package br.poli.view.console.state;

import br.poli.enums.GameDifficulty;
import br.poli.facade.SudokuFacade;

public class InitialState extends State {

	private static final String PLAYER_NAME= "Inform your name: ";
	private static final String MSG_DIFFICULTY_GAME = "Inform the number a number of the difficulty game (1) EASY, (2) NORMAL, (3) HARD: ";
	private static final String MSG_AGE_PLAYER = "Inform your age: ";

	public InitialState(SudokuFacade facade) {
		super(facade);
	}

	@Override
	public void executeCommand() {
		System.out.print(PLAYER_NAME);
		String playerName = sc.nextLine();

		int gameDifficulty = 0;

		while (GameDifficulty.getDifficultyByLevel(gameDifficulty) == null) {
			System.out.print(MSG_DIFFICULTY_GAME);
			gameDifficulty = sc.nextInt();
			System.out.println();
		}
		int age = 0;
		System.out.print(MSG_AGE_PLAYER);
		age = sc.nextInt();

		this.facade.create(playerName, age, GameDifficulty.getDifficultyByLevel(gameDifficulty));

		System.out.print(MSG_INIT_OR_EXIT);
		facade.setActualPosition(sc.nextInt());
		this.facade.init();
	}

	@Override
	public State nextState() {
		if (this.facade.getActualPosition() == 1) {
			return new InGameState(this.facade);
		} else {
			return new ExitState(this.facade);
		}
	}
}
