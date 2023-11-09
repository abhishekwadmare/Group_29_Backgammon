import java.util.Random;

public class Dice
{
    public static int diceOne, diceTwo;
    public static boolean diceOneRolled = false, diceTwoRolled = false;

    public static int roll()
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}