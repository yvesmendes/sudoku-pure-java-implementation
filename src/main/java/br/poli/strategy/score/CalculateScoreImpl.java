package br.poli.strategy.score;

import java.util.Date;

import br.poli.enums.GameDifficulty;

/**
 * Default implementation for {@link CalculateScore}
 * @author yvesmendes
 *
 */
public class CalculateScoreImpl implements CalculateScore{
	private static final int MULTIPLY_FACTOR = 1000;
	private static final int MULTIPLY_FACTOR_LOWER = 100;
	private static final int MINUTE_BASE = 10;
	
	@Override
	public int calculate(int quantityOfErrors, Date time, GameDifficulty gameDifficulty){
		int quantityErrors = quantityOfErrors * MULTIPLY_FACTOR_LOWER;
		int difference = this.convertToMinutes(new Date().getTime() - time.getTime());
		
		if(difference > MINUTE_BASE){
			difference = 0; 
		}else{
			difference = MINUTE_BASE - difference;
			difference *= MULTIPLY_FACTOR;
		}
		
		difference += MULTIPLY_FACTOR;
		int score = (int) ((difference * gameDifficulty.getFactor()) - quantityErrors);
		return score;
	}
	
	private int convertToMinutes(long diferenca){
		return (int) (( diferenca / 60000 ) % 60);
	}
}
