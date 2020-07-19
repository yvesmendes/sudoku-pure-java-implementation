package br.poli.enums;

/**
 * Define the values for the difficulty
 * @author yvesmendes
 *
 */
public enum GameDifficulty {
	
	EASY(1, 0.1f), NORMAL(2, 0.3f), HARD(3, 0.5f);

	private float factor;
	private int level;

	private GameDifficulty(int level, float factor) {
		this.factor = factor;
		this.level = level;
	}

	public float getFactor() {
		return factor;
	}

	public static GameDifficulty getDifficultyByLevel(int level) {

		for (GameDifficulty gameDifficulty : GameDifficulty.values()) {
			if (level == gameDifficulty.level) {
				return gameDifficulty;
			}
		}

		return null;
	}

}
