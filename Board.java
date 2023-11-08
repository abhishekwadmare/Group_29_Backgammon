
import java.util.ArrayList;
public class Board
{
    private Triangles triangles;
    private Bar redBar;
    private Bar whiteBar;
    public static final int TOTAL_TRIANGLES = 24;
    public static final int TOTAL_CHECKERS = 30;

    public Board() {
        redBar = new Bar("RED");
        whiteBar = new Bar("WHITE");
        triangles = new Triangles();
    }

    public Boolean isGameOver(){
        return false;
    }
    public Bar getRedBar() {
        return redBar;
    }
    public Bar getWhiteBar() {
        return whiteBar;
    }
    public Triangles getTriangles(){
        return triangles;
    }
}
