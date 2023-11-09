import java.util.ArrayList;

public class Triangles {

    private ArrayList<Triangle> triangles = new ArrayList<>(Board.TOTAL_TRIANGLES);

    public Triangles(){
        for (int i = 1; i <= Board.TOTAL_TRIANGLES; i++) {
            Triangle triangle;

            switch (i) {
                case 1: triangle = new Triangle(2, "RED");
                    break;
                case 6, 13: triangle = new Triangle(5, "WHITE");
                    break;
                case 8: triangle = new Triangle(3, "WHITE");
                    break;
                case 12, 19: triangle = new Triangle(5, "RED");
                    break;
                case 17: triangle = new Triangle(3, "RED");
                    break;
                case 24: triangle = new Triangle(2, "WHITE");
                    break;
                default:
                    triangles.add(new Triangle());
                    continue;
            }
            triangles.add(triangle);
        }
    }

    public Triangle getTriangle(int i){
        return triangles.get(i);
    }
}
