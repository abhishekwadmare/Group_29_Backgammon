public interface Lane {
    public String getColor();
    public void insertChecker(Checker checker);
    public Checker removeChecker();
}
