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

    public static void move(Board board)
    {
        String command = View.getInput().toUpperCase();
        switch (command){
            case "QUIT":
                Board.quit = true;
                System.out.println("Bye!!!");
                break;
            case "ROLL":
                Dices.roll(1);
                Dices.roll(2);
                break;
            default:
                View.isWrongInput = true;
                return;
        }
        View.isWrongInput = false;
        switchPlayer();
    }

    public static void whoPlaysFirst(Board board){

    }
}
