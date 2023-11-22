import java.util.Scanner;
import java.util.ArrayList;
public class View {
    public static boolean isWrongInput = false;
    public static void displayBoard(Board board){
        displayHeader();
        displayPlayer(board);
        displayTopTriangles(board);
        displayBottomTriangles(board);
        boolean diceRolled = Dices.status();
        displayDice();
        if(diceRolled) displayMoves(board);
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

    public static void displayDice(){
        System.out.println(" Dices One \t  Dices Two");
        if(Dices.diceOneRolled && Dices.diceTwoRolled){
            System.out.println("[  " + Dices.diceOne + "  ]  " + "    [  " + Dices.diceTwo + "  ]");
            Dices.diceOneRolled = false;
            Dices.diceTwoRolled = false;
        } else {
            System.out.println(" [     ]  " + "    [     ]");
        }
    }
    public static void displayTopTriangles(Board board){
        System.out.print("\t   13       14       15       16       17       18       19       20       21       22       23       24");
        System.out.print("\n\t");
        for(int i = 12; i < 24; i++)
            System.out.printf(board.getTriangles().getTriangle(i) + "  ");

    }

    public static void displayBottomTriangles(Board board){
        System.out.print("\n\n\t");
        for(int i = 11; i >= 0; i--)
            System.out.print(board.getTriangles().getTriangle(i) + "  ");
        System.out.print("\n\t ");
        System.out.println("  12       11       10       9        8         7        6        5        4        3       2        1   ");
        System.out.print("\n");
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        if(isWrongInput){
            System.out.print("\nLast command was invalid, please enter a valid command");
            isWrongInput = false;
        }
        System.out.print("\ninput your move: ");
        return sc.nextLine();
    }
    public static void displayMoves(Board board) {
        String playerColour = board.getActivePlayer().getColour();
        int[] diceValues = {Dices.diceOne, Dices.diceTwo, Dices.diceTwo + Dices.diceOne};
        ArrayList<ArrayList<int[]>> allMoves = new ArrayList<>();

        for (int diceValue : diceValues) {
            ArrayList<int[]> diceMoves = new ArrayList<>();
            for (Triangle t : board.getTriangles().getColoredTriangles()) {
                if (t.getColor() == null || t.getColor().equals(playerColour)) {
                    int index = t.getId();
                    if (Moves.isValidMove(board, index, diceValue)) {
                        int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
                        diceMoves.add(new int[]{index, targetIndex});
                    }
                }
            }
            allMoves.add(diceMoves);
        }

        for (int i = 0; i < allMoves.size(); i++) {
            System.out.println("Option " + (i+1) + ":");
            int choice=0;
            for (int[] move : allMoves.get(i)) {
                if(move[1]>Board.TOTAL_TRIANGLES || move[1]<0)
                    System.out.println(++choice+". Play "+move[0]+"- OFF");
                else
                    System.out.println(++choice+". Play "+move[0]+"-"+move[1]);
            }
        }
    }
}
