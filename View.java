import java.util.Scanner;
import java.util.ArrayList;
public class View {
    public static boolean isWrongInput = false, isPipCalled = false, isHintCalled = false;
    public static boolean displayMoves = false;
    public static void displayBoard(Board board){
        displayHeader();
        displayPlayer(board);
        displayPipScore(board);
        displayTopTriangles(board);
        displayBar(board);
        displayBottomTriangles(board);
        displayDice(board);
        if(displayMoves)
            displayMoves(board);
    }
    private static void displayBar(Board board) {
        System.out.println("\n                                                        Bar");
        System.out.printf("                                                       ["+board.getWhiteBar().bar.size()+" \u001B[31m"+board.getRedBar().bar.size()+"\u001B[0m]");
    }

    public static void displayHeader(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("                    ------   Backgammon   ------                  ");
        System.out.println("------------------------------------------------------------------");
    }

    public static void displayPlayer(Board board){
        Player player;
        if(Board.activePlayer == 1){
            player = board.playerOne;
        } else {
            player = board.playerTwo;
        }
        if (View.isWrongInput)
            System.out.println("It is still " + player.getName() + "'s turn:");
        else
            System.out.println("It is now " + player.getName() + "'s turn:");
        System.out.println("your checker's colour is: " + player.getColour());
    }

    public static void displayPipScore(Board board){
        int pipCount = 0;
        Player player = board.getActivePlayer();
        for (Triangle t : board.getTriangles().getColoredTriangles()) {
            if (t.getColor() == null || t.getColor().equals(board.getActivePlayer().getColour())) {
                int index = t.getId();
                int pipPointCount = (board.getActivePlayer() == board.playerOne) ? index * t.getCheckerCount() : (25 - index) * t.getCheckerCount();
                pipCount += pipPointCount;
                player.setPipcount(pipCount);
            }
        }
        System.out.println("Pip Count : " + pipCount);
    }
    public static void displayDice(Board board){
        System.out.println(" Dices One \t  Dices Two");
        if(Dices.isRolled()){
            if(Dices.diceOne == 0)
                System.out.println("  [     ]  " + "    [  " + Dices.diceTwo + "  ]\n");
            else if(Dices.diceTwo == 0)
                System.out.println("  [  " + Dices.diceOne + "  ]  " + "    [     ]\n");
            else
                System.out.println("  [  " + Dices.diceOne + "  ]  " + "    [  " + Dices.diceTwo + "  ]\n");
        } else {
            System.out.println("  [     ]  " + "    [     ]\n");
        }
    }
    public static void displayTopTriangles(Board board){
        System.out.print("\t   13       14       15       16       17       18       19       20       21       22       23       24");
        System.out.print("\n\t");
        for(int i = 12; i < 24; i++)
            System.out.printf(board.getTriangles().getTriangle(i) + "  ");

    }

    public static void displayBottomTriangles(Board board){
        System.out.print("\n\t");
        for(int i = 11; i >= 0; i--)
            System.out.print(board.getTriangles().getTriangle(i) + "  ");
        System.out.print("\n\t ");
        System.out.println("  12       11       10       9        8         7        6        5        4        3       2        1   ");
        System.out.print("\n");
    }

    public static String getInput(Board board){
        View.displayBoard(board);
        Scanner sc = new Scanner(System.in);
        if(isWrongInput){
            System.err.print("\nLast command was invalid, please enter a valid command :");
            isWrongInput = false;
        } else if (isPipCalled) {
            System.out.println("Pip counts:" +
                    "\nPlayer 1: "+board.playerOne.getPipcount() +
                    "\nPlayer 2: "+board.playerTwo.getPipcount());
            System.out.print("\ninput your move: ");
            isPipCalled = false;
        } else if (isHintCalled){
            if(!displayMoves)
                System.out.println("HINTS: " +
                        "\n1.''ROLL''" +
                        "\n2.''ROLL <Dice One Value> <Dice Two Value>''" +
                        "\n3.''PIP''" +
                        "\n4.''QUIT''");
            else
                System.out.println("HINTS: " +
                        "\n1.''<Option-number> <Move-number>''" +
                        "\n2.''PIP''" +
                        "\n3.''QUIT''");
            System.out.print("\ninput your move: ");
            isHintCalled = false;
        }
        else
            System.out.print("\ninput your move: ");
        return sc.nextLine();
    }
    public static void displayMoves(Board board) {
        String playerColour = board.getActivePlayer().getColour();
        Bar curr_bar =  Board.activePlayer == 1 ? board.getWhiteBar(): board.getRedBar();
        int[] diceValues = {Dices.diceOne, Dices.diceTwo, Dices.diceTwo + Dices.diceOne};
        ArrayList<ArrayList<int[]>> allMoves = new ArrayList<>();
        if(Dices.diceOne == 0 || Dices.diceTwo == 0)
            diceValues[2] = 0;

        for (int diceValue : diceValues) {
            int index;
            ArrayList<int[]> diceMoves = new ArrayList<>();
            if(curr_bar.bar.isEmpty())
            {
                for (Triangle t : board.getTriangles().getColoredTriangles()) {
                    if(diceValue == 0)
                        break;
                    if (t.getColor() == null || t.getColor().equals(playerColour)) {
                        index = t.getId();
                        if (Moves.isValidMove(board, index, diceValue)) {
                            int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
                            diceMoves.add(new int[]{index, targetIndex});
                        }
                    }
                }
            }
            else
            {
                index = Board.activePlayer==1? 25:0;
                if (Moves.isValidMove(board, index, diceValue)) {
                    int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
                    diceMoves.add(new int[]{index, targetIndex});
                }
            }
            allMoves.add(diceMoves);
        }
        board.possibleMoves = allMoves;
        for (int i = 0; i < allMoves.size(); i++) {
            if(allMoves.get(i).isEmpty())
                System.out.println("Option " + (i+1) + ": Not Available");
            else
                System.out.println("Option " + (i+1) + ":");
            int choice=0;
            for (int[] move : allMoves.get(i)) {
                String moveText = ++choice + ". Play ";
                if(move[0] == 0|| move[0] == 25) {
                    System.out.println(moveText + "Bar - " + move[1]);
                } else if(move[1] > Board.TOTAL_TRIANGLES || move[1] < 0) {
                    System.out.println(moveText + move[0] + "- OFF");
                } else {
                    System.out.println(moveText + move[0] + "-" + move[1]);
                }
            }
        }

    }
}
