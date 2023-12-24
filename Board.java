
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private final Triangles triangles;
    private final Bar redBar;
    private final Bar whiteBar;
    public Player playerOne, playerTwo;
    ArrayList<ArrayList<int[]>> possibleMoves;
    public boolean isQuit = false;
    public final int TOTAL_TRIANGLES = 24;
    public static int no_of_matches = 0;

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

    public Boolean isMatchOver() {
        if (isQuit)
            if (getActivePlayer() == playerTwo) {
                System.out.println(playerOne.getName() + " Wins a Single!!");
                playerOne.setScore(1);
                return true;
            } else {
                System.out.println(playerTwo.getName() + " Wins a Single!!");
                playerTwo.setScore(1);
                return true;
            }
        if (playerOne.getPipCount() == 0 || (isQuit && (getActivePlayer() == playerTwo))) {
            System.out.print(playerOne.getName() + "Wins!!");
            if (triangles.getHomeQuadrantCheckerCount(this) > 0 || !redBar.bar.isEmpty()){
                System.out.println(" a BackGammon with " + (3 * Dices.doublingCube) + " points");
                playerOne.setScore(3 * Dices.doublingCube);
            }
            int opponent_checkers = 0;
            for (Triangle t : triangles.getColoredTriangles()) {
                if (t.getColor().equals("RED"))
                    opponent_checkers++;
            }
            if (opponent_checkers == 15)
            {
                System.out.println(" a Gammon with " + (2 * Dices.doublingCube) + " points");
                playerOne.setScore(2 * Dices.doublingCube);
            }
            else
                System.out.print(" a Single");
            playerOne.setScore(1);
            return true;
        } else if (playerTwo.getPipCount() == 0 || (isQuit && (getActivePlayer() == playerOne))) {
            System.out.println(playerTwo.getName() + "Wins!!");
            if (triangles.getHomeQuadrantCheckerCount(this) > 0 || !whiteBar.bar.isEmpty())
            {
                System.out.println(" a BackGammon" + (3 * Dices.doublingCube) + " points");
                playerTwo.setScore(3 * Dices.doublingCube);
            }
            int opponent_checkers = 0;
            for (Triangle t : triangles.getColoredTriangles()) {
                if (t.getColor().equals("WHITE"))
                    opponent_checkers++;
            }
            if (opponent_checkers == 15)
            {
                System.out.println(" a Gammon with " + (2 * Dices.doublingCube) + " points");
                playerTwo.setScore(2 * Dices.doublingCube);
            }
            else
                System.out.print(" a Single");
            playerTwo.setScore(1);
            return true;
        }
        return isQuit;
    }

    public boolean isGameOver() {
        if (isMatchOver() || isQuit) {
            no_of_matches++;
            isQuit = false;
            if (no_of_matches != View.matchLength) {
                setupNextMatch();
                return false;
            } else {
                if (playerOne.getScore() > playerTwo.getScore()) {
                    System.out.println(playerOne.getName() + " won " + playerOne.getScore() + " compared to "+ playerTwo.getScore()+" points of "+playerTwo.getName()+" in total " + View.matchLength+ " matches");
                    System.out.println(playerOne.getName() + " Wins the game!! ");
                }
                if (playerOne.getScore() < playerTwo.getScore()) {
                    System.out.println(playerTwo.getName() + " won " + playerTwo.getScore() + " compared to "+ playerOne.getScore()+" points of "+playerOne.getName()+" in total " + View.matchLength+ " matches");
                    System.out.println(playerTwo.getName() + " Wins the game!! ");
                }
                return true;
            }
        }
        return false;
    }


    private void setupNextMatch() {
        View.displayHeader();
        playerOne.resetPlayer();
        playerTwo.resetPlayer();
        redBar.resetBar();
        whiteBar.resetBar();
        triangles.resetTriangles();
        determineTurn();
    }

    public Player getActivePlayer() {
        if (View.activePlayer == 1)
            return playerOne;
        return playerTwo;
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

    public void determineTurn() {
        Dices.roll(1);
        Dices.roll(2);
        System.out.println("Player 1 rolls Dice 1 and Player 2 rolls Dice 2");
        System.out.println();

        do {
            if (Dices.diceOne < Dices.diceTwo)
                View.activePlayer = 2;
            else
                View.activePlayer = 1;
            View.displayDice(this);
        } while (Dices.diceOne == Dices.diceTwo);
        System.out.println();

        if (View.activePlayer == 1)
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
