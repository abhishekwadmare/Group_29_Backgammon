import java.util.ArrayList;
import java.util.List;

public class Moves {

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void switchPlayer(){
        if(Board.activePlayer == 1)
            Board.activePlayer = 2;
        else
            Board.activePlayer = 1;
    }

    public static void move(Board board)
    {
        String command = View.getInput().toUpperCase();
        switch (command){
            case "QUIT":
                Board.quit = true;
                System.out.println("Bye!!!");
                break;
            case "ROLL":
                Dices.roll(1);
                Dices.roll(2);
                View.displayDice();
                View.displayMoves(board);
                break;
            default:
                View.isWrongInput = true;
                return;
        }
        if (View.isWrongInput) return;
        switchPlayer();
    }

    public static boolean isValidMove(Board board, int index, int diceValue) {
        int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
        if (targetIndex > 0 && targetIndex <= Board.TOTAL_TRIANGLES ) {
            Triangle targetTriangle = board.getTriangles().getTriangle(targetIndex - 1);
            if (targetTriangle.getColor() == null || targetTriangle.getColor().equals(board.getActivePlayer().getColour()) || targetTriangle.triangle.size() <= 1) {
                return true;
            }
        }
        return false;
    }
    public static void whoPlaysFirst(Board board){

    }
}
