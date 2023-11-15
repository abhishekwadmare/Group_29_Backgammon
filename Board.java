
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    private Triangles triangles;
    private Bar redBar, whiteBar;
    public Player playerOne, playerTwo;
    public static boolean quit = false;
    public static final int TOTAL_TRIANGLES = 24;
    public static final int TOTAL_CHECKERS = 30;
    public static int activePlayer = 1;

    public Board() {
        View.displayHeader();
        playerOne = setupPlayer();
        playerTwo = setupPlayer();
        redBar = new Bar("RED");
        whiteBar = new Bar("WHITE");
        triangles = new Triangles();
        determineTurn();
    }

    public Player setupPlayer(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String name;
        String color;
        System.out.println("  ---  Welcome Player " + activePlayer + "   ---   ");
        System.out.print("Enter Your Name: ");
        name = scanner.nextLine();
        if(activePlayer == 1)
            color = "WHITE";
        else
            color = "RED";
        Moves.switchPlayer();
        System.out.println();
        return new Player(name, color);
    }

    public Boolean isGameOver(){
        return Board.quit;
    }
    public Bar getRedBar() {
        return redBar;
    }
    public Bar getWhiteBar() {
        return whiteBar;
    }
    public Triangles getTriangles() {
        return triangles;
    }
    public void determineTurn(){
        Dices.roll(1);
        Dices.roll(2);
        System.out.println("Player 1 rolls Dice 1 and Player 2 rolls Dice 2");
        System.out.println();

        do {
            if(Dices.diceOne < Dices.diceTwo)
                activePlayer = 2;
            else
                activePlayer = 1;
            View.displayDice();
        }while(Dices.diceOne == Dices.diceTwo);
        System.out.println();

        if(activePlayer == 1)
            System.out.println("Congratulations " + playerOne.getName() + " you got bigger dice!");
        else
            System.out.println("Congratulations " + playerTwo.getName() + " you got bigger dice!");
        System.out.print("\nPress Enter to start Game : ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }
}
