public class Main {
    public static void main(String [] args){
        Board board = new Board();
        while(!board.isGameOver()){
            Moves.move(board, View.getInput(board));
        }
    }
}