import java.util.Scanner;

public class Moves {

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

    public static void move(Board board, String command){
        switch (command.strip().length()){
            case 1:
                if(command.strip().equals("q") || command.strip().equals("Q")){
                    Board.quit = true;
                    System.out.println("Bye!!!");
                }

                else if(command.strip().equals("r") || command.strip().equals("R")){
                    Dice.diceOne = Dice.roll();
                    Dice.diceOneRolled = true;
                    Dice.diceTwo = Dice.roll();
                    Dice.diceTwoRolled = true;
                }
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid command please enter a valid command");
        }
        switchPlayer();
    }
    public static void whoPlaysFirst(Board board){

    }
}
