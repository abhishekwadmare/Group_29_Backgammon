public class Moves {
    public static void move(Board board, String command){
        switch (command.strip()){
            case "q", "Q": Board.quit = true;
            break;
        }
    }
}
