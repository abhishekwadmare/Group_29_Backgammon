public class Moves {

    public static void switchPlayer() {
        if (View.activePlayer == 1)
            View.activePlayer = 2;
        else
            View.activePlayer = 1;
    }

    public static void move(Board board, String commandLine) {
        String[] command = commandLine.toUpperCase().split(" ");
        switch (command[0].length()) {
            case 6:
                switch (command[0]) {
                    case "ACCEPT":
                        if (View.isDoublingOffered) {
                            Dices.setDoublingCubeOwner(board);
                            View.isDoublingOffered = false;
                        } else {
                            View.isWrongInput = true;
                            return;
                        }
                        break;
                    case "REFUSE":
                        if (View.isDoublingOffered) {
                            board.isQuit = true;
                            System.out.println(board.getActivePlayer().getName() + " Loses this match!!!");
                            View.isDoublingOffered = false;
                            return;
                        } else {
                            View.isWrongInput = true;
                            return;
                        }
                    case "DOUBLE":
                        View.isDoublingOffered = true;
                        Dices.rollDoublingCube();
                        break;
                }
                break;
            case 4:
                switch (command[0]) {
                    case "QUIT":
                        board.isQuit = true;
                        System.out.println("Bye!!!");
                        break;
                    case "ROLL":
                        //Rolling dice with manual values
                        if (command.length == 3) {
                            if (Character.isDigit(command[1].charAt(0)) &&
                                    Character.isDigit(command[2].charAt(0))) {
                                Dices.roll(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                                View.displayMoves = true;
                                board.getActivePlayer().remainingMoves = 2;
                            } else {
                                // If the manual values are not digits
                                View.isWrongInput = true;
                                return;
                            }
                        } else {
                            // Random values assigned to both dice
                            Dices.roll();
                            View.displayMoves = true;
                            board.getActivePlayer().remainingMoves = 2;
                        }
                        break;
                    case "HINT":
                        View.isHintCalled = true;
                        return;
                    case "TEST":
                        Commands commands = new Commands(command[1].toLowerCase());
                        for (String commandL : commands) {
                            View.displayBoard(board);
                            System.out.println("\nInput from file: " + commandL);
                            move(board, commandL);
                            if (View.isWrongInput) {
                                System.err.print("\nLast command from file was invalid, please enter a valid command!!!");
                                View.isWrongInput = false;
                                return;
                            }
                        }
                        return;
                    default:
                        View.isWrongInput = true;
                        return;
                }
                break;
            case 3:
                switch (command[0]) {
                    case "PIP":
                        View.isPipCalled = true;
                        break;
                    default:
                        View.isWrongInput = true;
                        return;
                }

            case 1:
                int option = Integer.parseInt(command[0]) - 1;
                int move = Integer.parseInt(command[1]) - 1;
                if (board.getActivePlayer().remainingMoves == 2) {
                    if (option == 0)
                        Dices.diceOne = 0;
                    else if (option == 1)
                        Dices.diceTwo = 0;
                }
                moveChecker(option, move, board);
                if (View.isWrongInput)
                    return;
                break;
            default:
                View.isWrongInput = true;
                return;
        }
        if (View.isWrongInput) return;
        if (board.getActivePlayer().remainingMoves <= 0) {
            Dices.resetDice();
            View.displayMoves = false;
            switchPlayer();
        }

    }

    public static void moveChecker(int option, int move, Board board) {
        try {
            int source = board.possibleMoves.get(option).get(move)[0] - 1;
            int target = board.possibleMoves.get(option).get(move)[1] - 1;
            if (source - target == Dices.diceOne + Dices.diceTwo)
                board.getActivePlayer().remainingMoves -= 2;
            else
                board.getActivePlayer().remainingMoves -= 1;
            if (source == -1 || source == 24) {
                Bar bar = source == -1 ? board.getRedBar() : board.getWhiteBar();
                Triangle targetTriangle = board.getTriangles().getTriangle(target);
                targetTriangle.insertChecker(bar.removeChecker(), board);
            } else if (target >= board.TOTAL_TRIANGLES || target < 0) {
                Triangle sourceTriangle = board.getTriangles().getTriangle(source);
                sourceTriangle.removeChecker();
            } else {
                Triangle sourceTriangle = board.getTriangles().getTriangle(source);
                Triangle targetTriangle = board.getTriangles().getTriangle(target);
                Checker tempChecker = sourceTriangle.removeChecker();
                targetTriangle.insertChecker(tempChecker, board);
            }
        } catch (IndexOutOfBoundsException e) {
            View.isWrongInput = true;
        }
    }

    public static boolean isValidMove(Board board, int index, int diceValue) {
        int targetIndex = (board.getActivePlayer() == board.playerOne) ? index - diceValue : index + diceValue;
        if (targetIndex > 0 && targetIndex <= board.TOTAL_TRIANGLES) {
            Triangle targetTriangle = board.getTriangles().getTriangle(targetIndex - 1);
            if (targetTriangle.getColor() == null || targetTriangle.getColor().equals(board.getActivePlayer().getColour()) || targetTriangle.triangle.size() <= 1) {
                return true;
            }
        } else
            return board.getTriangles().getHomeQuadrantCheckerCount(board) == 15;
        return false;
    }

}
