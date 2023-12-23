import java.util.Random;

public class Dices
{
    public static int diceOne, diceTwo;
    private static boolean diceOneRolled = false, diceTwoRolled = false;

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

    public static void roll(){
        Random rand = new Random();
        diceOne = rand.nextInt(6) + 1;
        diceTwo = rand.nextInt(6) + 1;
        diceOneRolled = true;
        diceTwoRolled = true;
    }

    public static void roll(int diceOneValue, int diceTwoValue){
        diceOne = diceOneValue;
        diceTwo = diceTwoValue;
        diceOneRolled = true;
        diceTwoRolled = true;
    }

    public static void resetDice(){
        diceOneRolled = false;
        diceTwoRolled = false;
    }

    public static boolean isRolled() {
        return diceTwoRolled && diceOneRolled;
    }
}