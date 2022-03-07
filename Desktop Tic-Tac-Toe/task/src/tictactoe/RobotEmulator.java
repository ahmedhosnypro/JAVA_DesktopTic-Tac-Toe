package tictactoe;

import java.util.List;
import java.util.Random;

public class RobotEmulator {
    private final TicTacToe ticTacToe;


    public RobotEmulator(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    BoardCell getButton(String chosenButtonName) {
        BoardCell button = ticTacToe.getBoard().getButtonList().iterator().next();
        for (var btn : ticTacToe.getBoard().getButtonList()) {
            if (btn.getName().equals(chosenButtonName)) {
                button = btn;
            }
        }
        return button;
    }

    String getButtonName(int[] cellCoord) {
        int row = cellCoord[0];
        int column = cellCoord[1];
        char rowChar = '3';
        char columnChar = '3';
        switch (row) {
            case 1:
                rowChar = '2';
                break;
            case 2:
                rowChar = '1';
                break;
            default:
                break;
        }
        switch (column) {
            case 0:
                columnChar = 'A';
                break;
            case 1:
                columnChar = 'B';
                break;
            case 2:
                columnChar = 'C';
                break;
            default:
                break;
        }
        return "Button" + columnChar + rowChar;
    }

    int[] chooseCell() {
        int row;
        int column;
        do {
            int[] cord;
            switch (ticTacToe.getCurrentPlayer().getLevel()) {
                case EASY:
                    cord = calcEasyMove();
                    break;
                case MEDIUM:
                    cord = calcMediumMove(ticTacToe.getBoard().boardGrid, ticTacToe.getCurrentPlayer().getGameChar());
                    break;
                case ROBOT:
                case HARD:
                    cord = calcHardMove(ticTacToe.getBoard().boardGrid, ticTacToe.getCurrentPlayer().getGameChar());
                    break;
                default:
                    cord = new int[]{-1, -1};
            }
            row = cord[0];
            column = cord[1];
        } while (!checkMove(ticTacToe.getBoard().boardGrid, row, column));
        return new int[]{row, column};
    }

    private int[] calcEasyMove() {
        Random random = new Random();
        return new int[]{random.nextInt(3), random.nextInt(3)};
    }

    private int[] calcMediumMove(BoardGrid grid, char currentTurnXO) {
        //getting simplified version of game board cell as 3 rows, columns, main and side diagonal
        var sides = grid.getSides();

        //check against losing
        int[] cord = getSemiFullSideCoord(sides, currentTurnXO, 'X', 'O');

        if (cord[0] == -1) {  //if there's no chance for opposite player to win, it can choose any cell
            cord = calcEasyMove();
        }

        return cord;
    }

    private int[] calcHardMove(BoardGrid grid, char currentTurnXO) {
        int[] cord;      //fantasy coords
        //getting simplified version of game board cell as 3 rows, columns, main and side diagonal
        var sides = grid.getSides();

        //check for winning
        cord = getSemiFullSideCoord(sides, currentTurnXO, 'O', 'X');

        //check against losing
        if (cord[0] == -1) {
            cord = getSemiFullSideCoord(sides, currentTurnXO, 'X', 'O');
        }

        //check diagonals for high priority cell
        if (cord[0] == -1) {
            cord = getSemiEmptySideCoord(sides, currentTurnXO);
        }

        if (cord[0] == -1) {
            cord = calcEasyMove();
        }

        return cord;
    }

    //getting board coordinate from simplified side coordinate
    private int[] getCordFromSideCoords(List<Character> side, int sideIndex, int yEmptyCell) {
        int row = -1;
        int column = -1;
        int[] cord = {row, column};
        if (side.get(yEmptyCell) == ' ') {      //rechecking if the cell is empty
            switch (sideIndex) {        //getting the coordinate according to sides order in the list
                case 0:     //main diagonal
                    row = yEmptyCell;
                    column = yEmptyCell;
                    break;
                case 1:     //side diagonal
                    if (yEmptyCell == 0) {      //re-reverse for side diagonal
                        row = 0;
                        column = 2;
                    } else if (yEmptyCell == 1) {
                        row = 1;
                        column = 1;
                    } else {
                        row = 2;
                        column = 0;
                    }
                    break;
                case 2:     //fst Row
                case 3:     //snd Row
                case 4:     // 3rd Row
                    row = sideIndex - 2;
                    column = yEmptyCell;
                    break;
                case 5:     //fst Column
                case 6:     //snd Column
                case 7:     //3rd Column
                    row = yEmptyCell;
                    column = sideIndex - 5;
                    break;

                default:
                    break;
            }
            cord[0] = row;
            cord[1] = column;
            return cord;
        }

        return cord;
    }

    boolean checkMove(BoardGrid grid, int row, int column) {
        return grid.getGrid().get(row).get(column) == ' ';
    }

    private int[] getSemiFullSideCoord(List<List<Character>> sides, char currentTurnXO, char o, char x) {
        int sideIndex = 0;
        for (var side : sides) {
            int xCnt = 0;       //counting how many X for each side
            int oCnt = 0;       //counting how many O for each side
            var sideStatistics = getSemiFullSideStatistics(side);
            xCnt += sideStatistics[0];
            oCnt += sideStatistics[1];
            int yEmptyCell = sideStatistics[2];

            //check for winning
            if ((xCnt == 0 && oCnt == 2 && currentTurnXO == o)
                    || (oCnt == 0 && xCnt == 2 && currentTurnXO == x)) {
                return getCordFromSideCoords(side, sideIndex, yEmptyCell);
            }
            sideIndex++;
        }
        return new int[]{-1, -1};
    }

    private int[] getSemiEmptySideCoord(List<List<Character>> sides, char currentTurnXO) {
        var sideIndex = 0;
        for (var side : sides) {
            int xCnt = 0;       //counting how many X for each side
            int oCnt = 0;       //counting how many O for each side
            var sideStatistics = getSemiEmptySideStatistics(side);
            xCnt += sideStatistics[0];
            oCnt += sideStatistics[1];
            int yEmptyCell = sideStatistics[2];

            //check for winning
            if (((xCnt == 0 && oCnt == 1 && currentTurnXO == 'X')
                    || (oCnt == 0 && xCnt == 1 && currentTurnXO == 'O'))) {
                return getCordFromSideCoords(side, sideIndex, yEmptyCell);
            }
            sideIndex++;
        }
        return new int[]{-1, -1};
    }

    private int[] getSemiFullSideStatistics(List<Character> side) {
        int yEmptyCell = 1;     //Y coordinate for empty cell in the row
        int xCnt = 0;       //counting how many X for each side
        int oCnt = 0;       //counting how many O for each side
        for (int elem = 0; elem < 3; elem++) {
            if (side.get(elem) == 'X') {
                xCnt++;
            } else if (side.get(elem) == 'O') {
                oCnt++;
            } else if (side.get(elem) == ' ') {
                yEmptyCell = elem;
            }
        }
        return new int[]{xCnt, oCnt, yEmptyCell};
    }

    private int[] getSemiEmptySideStatistics(List<Character> side) {
        int yEmptyCell = 1;     //Y coordinate for empty cell in the row
        int xCnt = 0;       //counting how many X for each side
        int oCnt = 0;       //counting how many O for each side
        for (int elem = 0; elem < 3; elem++) {
            if (side.get(elem) == 'X') {
                xCnt++;
            } else if (side.get(elem) == 'O') {
                oCnt++;
            }
        }
        return new int[]{xCnt, oCnt, yEmptyCell};
    }
}
