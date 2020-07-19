package br.poli.model;

/**
 * Domain class for a player
 * @author yvesmendes
 *
 */
class Player extends Person{

	private double biggestScore = 0;
	
	public Player(String name, int age) {
		super(name, age);
	}

	/**
	 * @return the biggestScore
	 */
	public double getBiggestScore() {
		return biggestScore;
	}

	/**
	 * @param biggestScore the biggestScore to set
	 */
	public void setBiggestScore(double biggestScore) {
		this.biggestScore = biggestScore;
	}
}
