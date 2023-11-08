public class Main {
    public static void main(String [] args){
        Board board = new Board();
        String command = "";
        while(!Board.quit){
            command = View.displayBoard(board);
            Moves.move(board, command);
        }
    }

}
