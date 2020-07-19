package br.poli.enums;

/**
 * Define the existent status for a game
 * @author yvesmendes
 *
 */
public enum GameStatus {
	
	NEW_GAME(1), EXIT(2), IN_GAME(3);

	private int level;

	private GameStatus(int level) {
		this.level = level;
	}

	public static GameStatus getByStatus(int status) {

		for (GameStatus gameStatus : GameStatus.values()) {
			if (status == gameStatus.level) {
				return gameStatus;
			}
		}

		return null;
	}

}
