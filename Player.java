public class Player
{
    String name, colour;
    int remainingMoves = 0;
    int score = 0;

    public void setPipcount(int pipcount) {
        this.pipcount = pipcount;
    }

    int pipcount;
    public int getPipcount() {
        return pipcount;
    }



    public Player(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
