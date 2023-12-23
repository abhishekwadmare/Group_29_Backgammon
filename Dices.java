import java.util.Random;

public class Dices
{
    public static int diceOne, diceTwo, doublingCube=1;
    private static boolean diceOneRolled = false, diceTwoRolled = false;
    public static Player doublingCubeOwner;

    public static void setDoublingCubeOwner(Board board) {
        Dices.doublingCubeOwner = board.getActivePlayer();
    }


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
    public static void rollDoublingCube()
    {
        if(doublingCube!=64)
        {
            doublingCube*=2;
            System.out.println("Stakes are now doubled to: "+doublingCube);
        }
        else
            System.err.println("Cannot Double Further");
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