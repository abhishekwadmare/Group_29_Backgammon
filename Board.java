
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    private Triangles triangles;
    private Bar redBar, whiteBar;
    public Player playerOne, playerTwo;
    ArrayList<ArrayList<int[]>> possibleMoves;
    public boolean isQuit = false;
    public final int TOTAL_TRIANGLES = 24;
    public final int TOTAL_CHECKERS = 30;

    public Board() {
        View.displayHeader();
        playerOne = View.setPlayer();
        playerTwo = View.setPlayer();
        View.setMatchLength();
        redBar = new Bar("RED");
        whiteBar = new Bar("WHITE");
        triangles = new Triangles(TOTAL_TRIANGLES);
        determineTurn();
    }

    public Player getActivePlayer()
    {
        if (View.activePlayer==1)
            return playerOne;
        return playerTwo;
    }


    public Boolean isGameOver(){
        return isQuit;
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
                View.activePlayer = 2;
            else
                View.activePlayer = 1;
            View.displayDice(this);
        }while(Dices.diceOne == Dices.diceTwo);
        System.out.println();

        if(View.activePlayer == 1)
            System.out.println("Congratulations " + playerOne.getName() + " you got bigger dice!");
        else
            System.out.println("Congratulations " + playerTwo.getName() + " you got bigger dice!");
        Dices.resetDice();
        System.out.print("\nPress Enter to start Game : ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }
}
