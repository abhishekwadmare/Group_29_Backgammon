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
