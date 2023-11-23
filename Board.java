
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    private Triangles triangles;
    private Bar redBar, whiteBar;
    public Player playerOne, playerTwo;
    ArrayList<ArrayList<int[]>> possibleMoves;
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
    }

    public Player getActivePlayer()
    {
        if (activePlayer==1)
            return playerOne;
        return playerTwo;
    }
    public Player setupPlayer(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String name;
        String color;
        System.out.println("Welcome Player" + activePlayer + " !");
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
}
