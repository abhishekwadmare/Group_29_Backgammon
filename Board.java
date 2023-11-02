
import java.util.ArrayList;
public class Board
{
    private ArrayList<Triangle> triangles;
    private Bar redBar;
    private Bar whiteBar;
    public static final int TOTAL_TRIANGLES = 24;
    public static final int TOTAL_CHECKERS = 30;

    public Board() {
        redBar = new Bar("RED");
        whiteBar = new Bar("WHITE");

        triangles = new ArrayList<>();

        for (int i = 1; i <= TOTAL_TRIANGLES; i++) {
            int numCheckers = 0;
            String checkerColor = null;

            switch (i) {
                case 1:
                    checkerColor = "RED";
                    numCheckers = 2;
                    break;
                case 6, 13:
                    checkerColor = "WHITE";
                    numCheckers = 5;
                    break;
                case 8:
                    checkerColor = "WHITE";
                    numCheckers = 3;
                    break;
                case 12, 19:
                    checkerColor = "RED";
                    numCheckers = 5;
                    break;
                case 17:
                    checkerColor = "RED";
                    numCheckers = 3;
                    break;
                case 24:
                    checkerColor = "WHITE";
                    numCheckers = 2;
                    break;
                default:
                    triangles.add(new Triangle());
                    continue;
            }
            triangles.add(new Triangle(numCheckers, checkerColor));
        }

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
    public ArrayList<Triangle> getTriangles(){
        return triangles;
    }
}
