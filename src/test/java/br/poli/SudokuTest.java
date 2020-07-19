//package br.poli;
//
//import br.poli.model.Game;
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
//public class SudokuTest extends TestCase {
//	/**
//	 * Create the test case
//	 *
//	 * @param testName
//	 *            name of the test case
//	 */
//	public SudokuTest(String testName) {
//		super(testName);
//	}
//
//	/**
//	 * @return the suite of tests being tested
//	 */
//	public static Test suite() {
//		return new TestSuite(SudokuTest.class);
//	}
//
//	/**
//	 * Rigourous Test :-)
//	 */
//	public void testApp() throws Exception {
//		Game p = Game.criaPartida().comDificuldade(GameDificulty.HARD).paraJogador("TESTE").inicia();
//		p.resolveTabuleiro();
//		
//		boolean tabuleiroResolvido = true;
//		for(int i = 0; i < p.getGrid().length; i++){
//			for(int z = 0; z < p.getGrid()[i].length; z++){
//				if(p.getGrid()[i][z] == 0){
//					tabuleiroResolvido = false;
//					break;
//				}
//			}
//		}
//		
//		assertTrue(tabuleiroResolvido);
//	}
//}
