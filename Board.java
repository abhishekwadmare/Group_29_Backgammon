
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    private Triangles triangles;
    private Bar redBar, whiteBar;
    public Player playerOne, playerTwo;
    public static final int TOTAL_TRIANGLES = 24;
    public static final int TOTAL_CHECKERS = 30;
    public static boolean quit = false;
    public static int activePlayer = 1;

    public Board() {
        playerOne = setupPlayer();
        playerTwo = setupPlayer();
        redBar = new Bar("RED");
        whiteBar = new Bar("WHITE");
        triangles = new Triangles();
    }

    public Player setupPlayer(){
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
        return new Player(name, color);
    }

    public Boolean isGameOver(){
        return false;
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
