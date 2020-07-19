package br.poli.view.console.state;

import br.poli.exceptions.InvalidMoveException;
import br.poli.exceptions.InvalidValueException;
import br.poli.facade.SudokuFacade;

public class InGameState extends State {

    private static final String MSG_X_VALUE = "X";
    private static final String MSG_Y_VALUE = "Y";
    private static final String MSG_INFORM_MOVE = "Please digit a number between 1 and 9: ";
    private static final String MSG_INVALID_MOVE = "The informed digit X: %d and Y: %d is invalid!";
    private static final String MSG_QUANTITY_OF_ERRORS = "Quantity of errors: %d";
    private static final String MSG_ELAPSED_TIME = "Elapsed time: %s";
    private static final String MSG_ANY_KEY_TO_CONTINUE = "\nPress any key to continue";
	private static final String MSG_CORRECT_MOVE = "Correct move!";

	public InGameState(SudokuFacade facade) {
        super(facade);
    }

    @Override
    public void executeCommand() {
        int positionX = 0;
        int positionY = 0;
        int actualMove = 0;

        this.showBoard();

        System.out.printf(MSG_POSITION, MSG_X_VALUE);
        positionX = sc.nextInt();

        System.out.printf(MSG_POSITION, MSG_Y_VALUE);
        positionY = sc.nextInt();

        System.out.print(MSG_INFORM_MOVE);
        actualMove = sc.nextInt();

        try {
            this.facade.makeMove(positionX, positionY, actualMove);
			System.out.println(MSG_CORRECT_MOVE);
        } catch (InvalidMoveException e) {
            System.out.println(MSG_INVALID_MOVE);
        } catch (InvalidValueException e) {
            System.out.println(String.format(MSG_INVALID_MOVE, positionX, positionY));
        }
        
        System.out.println(String.format(MSG_QUANTITY_OF_ERRORS, this.facade.getQuantityErrors()));
        System.out.print(String.format(MSG_ELAPSED_TIME, this.facade.getElapsedTime()));
        System.out.print(MSG_ANY_KEY_TO_CONTINUE);
        sc.nextLine();
        sc.nextLine();
    }

    @Override
    public State nextState() {
        if (this.facade.isWin()) {
            return new WinState(this.facade);
        }

        if (this.facade.endGame()) {
            return new LossState(this.facade);
        }

        return this;
    }
}
