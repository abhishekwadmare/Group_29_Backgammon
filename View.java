import java.util.Scanner;

public class View {
    public static String displayBoard(Board board){
        displayPlayer(board);
        displayTopTriangles(board);
        displayBottomTriangles(board);
        displayDice();
        return getInput();
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
        if(Dice.diceOneRolled && Dice.diceTwoRolled){
            System.out.println("[  " + Dice.diceOne + "  ]  " + "    [  " + Dice.diceTwo + "  ]");
            Dice.diceOneRolled = false;
            Dice.diceTwoRolled = false;
        } else {
            System.out.println(" [     ]  " + "    [     ]");
        }
        System.out.println("Dice One \t Dice Two");
    }
    public static void displayTopTriangles(Board board){
        System.out.print("\t");
        for(int i = 13; i < 25; i++) System.out.print("  " + i + "   ");
        System.out.print("\n\t");
        for(int i = 12; i < 24; i++)
            System.out.printf(board.getTriangles().getTriangle(i) + "  ");

    }

    public static void displayBottomTriangles(Board board){
        System.out.print("\n\n\t");
        for(int i = 11; i >= 0; i--)
            System.out.print(board.getTriangles().getTriangle(i) + "  ");
        System.out.print("\n\t");
        for(int i = 12; i > 0; i--) {
            if(i < 10)
                System.out.print("   " + i + "   ");
            else
                System.out.print("  " + i + "   ");
        }
        System.out.print("\n\n");
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input your move: ");
        return sc.nextLine();
    }
}
