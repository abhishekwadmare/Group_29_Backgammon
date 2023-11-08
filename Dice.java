import java.util.Random;

public class Dice
{
    static int value;

    public static int roll()
    {
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
        return value;
    }
}
