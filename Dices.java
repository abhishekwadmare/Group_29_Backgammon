import java.util.Random;

public class Dices
{
    public static int diceOne, diceTwo;
    public static boolean diceOneRolled = false, diceTwoRolled = false;

    public static void roll(int diceNumber)
    {
        Random rand = new Random();
        if(diceNumber==1) {
            diceOne = rand.nextInt(6) + 1;
            diceOneRolled = true;
        } else {
            diceTwo = rand.nextInt(6) + 1;
            diceTwoRolled = true;
        }
    }
}