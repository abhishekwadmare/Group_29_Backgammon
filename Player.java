public class Player {
    private final String name;
    private final String colour;
    private int pipCount = 167;
    int remainingMoves = 0;
    private int score=0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setPipCount(int pipCount) {
        this.pipCount = pipCount;
    }

    public int getPipCount() {
        return pipCount;
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

    public void resetPlayer() {
        remainingMoves = 0;
        pipCount = 167;
    }

}
