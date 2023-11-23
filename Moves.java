import java.util.ArrayList;
import java.util.List;

public class Moves {
    public static boolean switchPlayer = false;

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
        String[] command = View.getInput(board).toUpperCase().split(" ");
        switch (command.length){
            case 1:
                switch (command[0]){
                    case "QUIT":
                        Board.quit = true;
                        System.out.println("Bye!!!");
                        break;
                    case "ROLL":
                        Dices.roll(1);
                        Dices.roll(2);
                        board.getActivePlayer().remainingMoves = 2;
                        break;
                    default:
                        View.isWrongInput = true;
                        return;
                }
                break;
            case 2:
                int option = Integer.parseInt(command[0]) - 1;
                int move = Integer.parseInt(command[1]) - 1;
                if(board.getActivePlayer().remainingMoves == 2){
                    if(option == 0)
                        Dices.diceOne = 0;
                    else if(option == 1)
                        Dices.diceTwo = 0;
                }
                moveChecker(board.possibleMoves.get(option).get(move)[0] - 1, board.possibleMoves.get(option).get(move)[1] - 1, board);
                break;
            default:
                View.isWrongInput = true;
                return;
        }
        if (View.isWrongInput) return;
        if(board.getActivePlayer().remainingMoves <= 0){
            Dices.diceOneRolled = false;
            Dices.diceTwoRolled = false;
            View.displayMoves = false;
            switchPlayer();
        }

    }

    public static void moveChecker(int source, int target, Board board){
        if(source - target == Dices.diceOne + Dices.diceTwo)
            board.getActivePlayer().remainingMoves -= 2;
        else
            board.getActivePlayer().remainingMoves -= 1;
        Triangle sourceTriangle = board.getTriangles().getTriangle(source);
        Triangle targetTriangle = board.getTriangles().getTriangle(target);
        Checker tempChecker = sourceTriangle.removeChecker();
        targetTriangle.insertChecker(tempChecker);
    }

    public static boolean isValidMove(Board board, int index, int diceValue) {
        int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
        if (targetIndex > 0 && targetIndex <= Board.TOTAL_TRIANGLES ) {
            Triangle targetTriangle = board.getTriangles().getTriangle(targetIndex - 1);
            if (targetTriangle.getColor() == null || targetTriangle.getColor().equals(board.getActivePlayer().getColour()) || targetTriangle.triangle.size() <= 1) {
                return true;
            }
        }
        else
            return board.getTriangles().getHomeQuadrantCheckerCount(board) == 15;
        return false;
    }

}
