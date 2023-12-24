/**
 * Represents a single checker piece
 */
public class Checker {
    String colour;
    /**
     * Constructs a checker with the given color
     * @param colour The color of the checker
     */
    public Checker(String colour) {
        this.colour = colour;
    }
    /**
     * Gets the color of this checker
     * @return The checker color
     */
    public String getColour() {
        return colour;
    }

}
