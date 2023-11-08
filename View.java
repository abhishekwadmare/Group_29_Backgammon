import java.util.Scanner;

public class View {
    public static String displayBoard(Board board){
        displayTopTriangles(board);
        displayBottomTriangles(board);
        return getInput();
    }

    public static void displayTopTriangles(Board board){
        System.out.print("\t");
        for(int i = 13; i < 25; i++) System.out.print("  " + i + "   ");
        System.out.print("\n\t");
        for(int i = 12; i < 24; i++)
            System.out.printf(board.getTriangles().getTriangle(i) + "  ");

    }

    public static void displayBottomTriangles(Board board){
        System.out.print("\n\n\t");
        for(int i = 11; i >= 0; i--)
            System.out.print(board.getTriangles().getTriangle(i) + "  ");
        System.out.print("\n\t");
        for(int i = 12; i > 0; i--) {
            if(i < 10)
                System.out.print("   " + i + "   ");
            else
                System.out.print("  " + i + "   ");
        }
        System.out.println();
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input your move: ");
        return sc.nextLine();
    }
}
