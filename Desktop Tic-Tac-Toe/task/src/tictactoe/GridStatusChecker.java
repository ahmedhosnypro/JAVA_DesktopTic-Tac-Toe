package tictactoe;

import java.util.Arrays;

public class GridStatusChecker {
    final Board board;

    public GridStatusChecker(Board board) {
        this.board = board;
    }

    BoardStatus checkGridStatus() {
        BoardStatus boardStatus = BoardStatus.NOT_STARTED;
        int X = 0;
        int O = 0;
        int empty = 0;
        for (char[] row : board.boardGrid.getGrid()) {
            for (char ch : row) {
                if (ch == 'X') {
                    X++;
                } else if (ch == 'O') {
                    O++;
                } else if (ch == ' ') {
                    empty++;
                }
            }
        }

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
                    if (X <= O && empty != 9) {
                        boardStatus = BoardStatus.X_TURN;
                    } else if (O < X && empty != 9) {
                        boardStatus = BoardStatus.O_TURN;
                    }
                }
                break;
        }
        return boardStatus;
    }

    //return simple array representing fulfilled side with special case (X, O)
    char[] simplifySides() {
        char[][] side = board.boardGrid.getSides();
        char[] simplifiedSides = new char[board.boardGrid.getSides().length];
        Arrays.fill(simplifiedSides, 'f');
        for (int i = 0; i < side.length; i++) {
            char last = side[i][0];
            boolean isInRow = true;
            for (int j = 1; j < 3; j++) {
                if (side[i][j] == last) {
                    last = side[i][j];
                } else {
                    isInRow = false;
                    break;
                }
            }
            if (isInRow) {
                simplifiedSides[i] = side[i][0];
            }
        }
        return simplifiedSides;
    }

    String checkSides() {
        String check = "";
        char[] sides;
        sides = simplifySides();
        int X = 0;
        int O = 0;
        for (char side : sides) {
            if (side == 'X') {
                X++;
            } else if (side == 'O') {
                O++;
            }
        }
        if (X == 1 && O == 0) {
            check = "X_WINS";
        } else if (O == 1 && X == 0) {
            check = "O_WINS";
        }
        return check;
    }
}