public interface Lane {
    /**
     * Gets the color of this lane
     * @return The color as a String
     */
    public String getColor();
    /**
     * Inserts a checker into this lane
     * @param checker The checker to insert
     * @param board The game Board
     */
    public void insertChecker(Checker checker, Board board);
    /**
     * Removes and returns a checker from this lane
     * @return The removed Checker
     */
    public Checker removeChecker();
}
