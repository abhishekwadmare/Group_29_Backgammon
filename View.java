import java.util.Scanner;

public class View {
    public static void displayBoard(Board board){
        displayHeader();
        displayPlayer(board);
        displayTopTriangles(board);
        displayBottomTriangles(board);
        displayDice();
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
        System.out.println("It is now " + player.name + "'s turn:");
        System.out.println("your checkers colour is: " + player.colour);
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
        System.out.print("\ninput your move: ");
        return sc.nextLine();
    }
}
