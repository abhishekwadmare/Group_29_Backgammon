import java.util.Stack;

public class Triangle implements Lane{

    Stack<Checker> triangle;
    public Triangle()
    {
        triangle = new Stack<>();
    }
    public Triangle(int checkerCount, String color)
    {
        triangle = new Stack<>();
        for(int i = 0; i < checkerCount; i++)
            insertChecker(new Checker(color));
    }

    private String numberRepresentation(int n){
        if(n < 10) {
            return " " + n;
        } else
            return Integer.toString(n);
    }

    public String toString(){
        if(triangle.isEmpty()){
            return "[   ]";
        } else if(this.getColor().equals("RED")){
//            return "[" + "\033[0;31m" + numberRepresentation(triangle.size()) + "\033[0m" + "]";
            return "[R" + numberRepresentation(triangle.size()) + "]";
        } else {
            return "[W" + numberRepresentation(triangle.size()) + "]";
        }
    }

    @Override
    public String getColor(){
        if(triangle.isEmpty())
            return null;
        return triangle.peek().getColour();
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
