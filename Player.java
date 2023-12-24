public class Player
{
    String name, colour;
    int remainingMoves = 0;
    int score = 0;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    private int wins=0;
    public void setPipCount(int pipcount) {
        this.pipcount = pipcount;
    }

    int pipcount = 167;
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

    public void resetPlayer(){
        remainingMoves = 0;
        score = 0;
        pipcount = 167;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
