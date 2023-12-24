import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testBoardCreation() {
        Board board = new Board();
        assertEquals("RED", board.redBar.getColor());
        assertEquals("WHITE", board.whiteBar.getColor());
        assertEquals(24, board.TOTAL_TRIANGLES);
    }

    @Test
    public void testIsMatchOverQuit() {
        Board board = new Board();
        board.isQuit = true;
        board.playerOne = new Player("Player 1", "RED");
        board.playerTwo = new Player("Player 2", "WHITE");
        assertTrue(board.isMatchOver());
    }

    @Test
    public void testIsMatchOverPlayerOneWins() {
        Board board = new Board();
        board.playerOne = new Player("Player 1", "RED");
        board.playerTwo = new Player("Player 2", "WHITE");
        board.playerOne.setPipCount(0);
        assertTrue(board.isMatchOver());
    }

    @Test
    public void testIsMatchOverPlayerTwoWins() {
        Board board = new Board();
        board.playerOne = new Player("Player 1", "RED");
        board.playerTwo = new Player("Player 2", "WHITE");
        board.playerTwo.setPipCount(0);
        assertTrue(board.isMatchOver());
    }

    @Test
    public void testIsMatchOverNoWin() {
        Board board = new Board();
        board.playerOne = new Player("Player 1", "RED");
        board.playerTwo = new Player("Player 2", "WHITE");
        assertFalse(board.isMatchOver());
    }
    @Test
    public void testIsGameOver() {
        Board board = new Board();
        board.isQuit = true;
        assertTrue(board.isGameOver());
    }

    @Test
    public void testGetActivePlayer() {
        Board board = new Board();
        View.activePlayer = 1;
        assertEquals(board.playerOne, board.getActivePlayer());
    }

    @Test
    public void testGetRedBar() {
        Board board = new Board();
        assertEquals("RED", board.getRedBar().getColor());
    }

    @Test
    public void testGetWhiteBar() {
        Board board = new Board();
        assertEquals("WHITE", board.getWhiteBar().getColor());
    }

    @Test
    public void testGetTriangles() {
        Board board = new Board();
        assertEquals(24, board.getTriangles().getTriangles().size());
    }
}
