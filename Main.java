public class Main {
    public static void main(String [] args){
        Board board = new Board();
        String command;
        Moves.whoPlaysFirst(board);
        while(!Board.quit){
            command = View.displayBoard(board);
            Moves.move(board, command);
        }
    }
}
