package tictactoe;

import java.util.ArrayList;

public class GridStatusChecker {
    final Board board;
    int xCount = 0;
    int oCount = 0;
    int empty = 0;

    BoardStatus boardStatus = BoardStatus.NOT_STARTED;

    public GridStatusChecker(Board board) {
        this.board = board;
    }

    BoardStatus checkGridStatus() {
        getGridStatistics();
        switch (checkSides()) {
            case "X_WINS":
                boardStatus = BoardStatus.X_WINS;
                break;
            case "O_WINS":
                boardStatus = BoardStatus.O_WINS;
                break;
            default:
                if (empty == 0) {
                    boardStatus = BoardStatus.DRAW;
                } else if (empty > 0) {
                    if (xCount <= oCount && empty != 9) {
                        boardStatus = BoardStatus.X_TURN;
                    } else if (oCount < xCount && empty != 9) {
                        boardStatus = BoardStatus.O_TURN;
                    }
                }
                break;
        }
        return boardStatus;
    }

    //return simple array representing fulfilled side with special case (X, O)
    ArrayList<Character> simplifySides() {
        var side = board.boardGrid.getSides();
        ArrayList<Character> simplifiedSides = new ArrayList<>();
        for (var characters : side) {
            char last = characters.get(0);
            boolean isInRow = true;
            for (int j = 1; j < 3; j++) {
                if (characters.get(j) == last) {
                    last = characters.get(j);
                } else {
                    isInRow = false;
                    break;
                }
            }
            if (isInRow) {
                simplifiedSides.add(characters.get(0));
            }
        }
        return simplifiedSides;
    }

    String checkSides() {
        String check = "";
        int xRowCount = 0;
        int oRowCount = 0;
        for (char side : simplifySides()) {
            if (side == 'X') {
                xRowCount++;
            } else if (side == 'O') {
                oRowCount++;
            }
        }
        if (xRowCount == 1 && oRowCount == 0) {
            check = "X_WINS";
        } else if (oRowCount == 1 && xRowCount == 0) {
            check = "O_WINS";
        }
        return check;
    }

    private void getGridStatistics() {
        xCount = 0;
        oCount = 0;
        empty = 0;
        for (var row : board.boardGrid.getGrid()) {
            for (char ch : row) {
                if (ch == 'X') {
                    xCount++;
                } else if (ch == 'O') {
                    oCount++;
                } else if (ch == ' ') {
                    empty++;
                }
            }
        }
    }
}