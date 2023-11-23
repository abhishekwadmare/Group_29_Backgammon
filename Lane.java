public interface Lane {
    public String getColor();
    public void insertChecker(Checker checker, Board board);
    public Checker removeChecker();
}
