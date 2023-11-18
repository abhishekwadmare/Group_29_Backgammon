import java.util.Stack;

public class Triangle implements Lane{

    Stack<Checker> triangle;
    int id;
    public Triangle(int id)
    {
        triangle = new Stack<>();
        this.id = id;
    }
    public Triangle(int id, int checkerCount, String color)
    {
        this.id = id;
        triangle = new Stack<>();
        for(int i = 0; i < checkerCount; i++)
            insertChecker(new Checker(color));
    }

    private String numberRepresentation(int n){
        if(n<10){
            return " " + n;
        } else {
            return Integer.toString(n);
        }
    }

    public String toString(){
        if(triangle.isEmpty()){
            return "  [  ] ";
        } else if(this.getColor().equals("RED")){
            return "  [\u001B[31m" + numberRepresentation(triangle.size()) + "\u001B[0m] ";
        } else {
            return "  [\u001B[0m" + numberRepresentation(triangle.size()) + "] ";
        }
    }

    @Override
    public String getColor(){
        if(triangle.isEmpty())
            return null;
        return triangle.peek().getColour();
    }
    public int getId() {
        return id;
    }
    @Override
    public void insertChecker(Checker checker){
        if(this.getColor() == null || this.getColor().equals(checker.getColour()))
            triangle.add(checker);
    }
    @Override
    public Checker removeChecker(){
        if(!triangle.isEmpty()){
            return triangle.pop();
        }
        return null;
    }
}
