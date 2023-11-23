import java.util.Stack;

public class Bar implements Lane{
    Stack<Checker> bar;
    String color;

    public Bar(String color) {
        this.bar = new Stack<>();
        this.color = color;
    }

    @Override
    public String getColor(){
        return this.color;
    }

    @Override
    public void insertChecker(Checker checker, Board board){
        if(this.getColor().equals(checker.getColour()))
            bar.add(checker);
    }

    @Override
    public Checker removeChecker(){
        if(!bar.isEmpty()){
            return bar.pop();
        }
        return null;
    }
}
