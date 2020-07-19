package br.poli.strategy.score;

import java.util.Date;

import br.poli.enums.GameDifficulty;

/**
 * Interface to define the contract for a calculate score
 * @author yvesmendes
 *
 */
public interface CalculateScore {

	int calculate(int quantityOfErrors, Date time, GameDifficulty dificultyLevel);
}
