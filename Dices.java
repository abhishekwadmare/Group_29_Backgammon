import java.util.Random;
import java.util.Scanner;

public class Dices
{
    public static int diceOne, diceTwo;
    public static boolean diceOneRolled = false, diceTwoRolled = false;

    public static void roll(int diceNumber)
    {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        if(diceNumber==1) {
//            diceOne = rand.nextInt(6) + 1;
            System.out.print("dice 1: ");
            diceOne = scanner.nextInt();
            diceOneRolled = true;
        } else {
//            diceTwo = rand.nextInt(6) + 1;
            System.out.print("dice 2: ");
            diceTwo = scanner.nextInt();
            diceTwoRolled = true;
        }
    }

    public static boolean status() {
        return diceTwoRolled && diceOneRolled;
    }
}