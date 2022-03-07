package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Board extends JPanel {
    TicTacToe ticTacToe;
    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    BoardStatus boardStatus = BoardStatus.NOT_STARTED;

    //buttons
    final transient Set<BoardCell> buttonList = new LinkedHashSet<>(); //list of buttons
    final BoardCell buttonA3;
    final BoardCell buttonB3;
    final BoardCell buttonC3;
    final BoardCell buttonA2;
    final BoardCell buttonB2;
    final BoardCell buttonC2;
    final BoardCell buttonA1;
    final BoardCell buttonB1;
    final BoardCell buttonC1;


    transient BoardGrid boardGrid = new BoardGrid();
    final transient GridStatusChecker gridStatusChecker = new GridStatusChecker(this);

    public Board(String name, TicTacToe ticTacToe) {
        setName(name);
        setLayout(new GridLayout(3, 3));
        setBorder(border);

        this.ticTacToe = ticTacToe;

        buttonA3 = new BoardCell("ButtonA3", ticTacToe);
        buttonB3 = new BoardCell("ButtonB3", ticTacToe);
        buttonC3 = new BoardCell("ButtonC3", ticTacToe);
        buttonA2 = new BoardCell("ButtonA2", ticTacToe);
        buttonB2 = new BoardCell("ButtonB2", ticTacToe);
        buttonC2 = new BoardCell("ButtonC2", ticTacToe);
        buttonA1 = new BoardCell("ButtonA1", ticTacToe);
        buttonB1 = new BoardCell("ButtonB1", ticTacToe);
        buttonC1 = new BoardCell("ButtonC1", ticTacToe);


        //add buttons to buttonList
        buttonList.add(buttonA3);
        buttonList.add(buttonB3);
        buttonList.add(buttonC3);
        buttonList.add(buttonA2);
        buttonList.add(buttonB2);
        buttonList.add(buttonC2);
        buttonList.add(buttonA1);
        buttonList.add(buttonB1);
        buttonList.add(buttonC1);

        addButtons();
        setActionListeners();
    }

    private void addButtons() {
        for (var button : buttonList) {
            add(button);
        }
    }

    private void setActionListeners() {
        int row = 0;
        int column = 0;
        for (var button : buttonList) {
            int finalRow = row;
            int finalColumn = column;
            button.addActionListener(e -> {
                boardGrid.setGrid(ticTacToe.getCurrentPlayer().getGameChar(), finalRow, finalColumn);
                button.setText(String.valueOf(ticTacToe.getCurrentPlayer().getGameChar()));
                button.setEnabled(false);
                updateBoardStatus();
                switch (boardStatus) {
                    case X_TURN:
                    case O_TURN:
                        ticTacToe.switchPlayer();
                        ticTacToe.getStatusBar().updateLabelStatus();
                        ticTacToe.getCurrentPlayer().play();
                        break;
                    case X_WINS:
                    case O_WINS:
                    case DRAW:
                        ticTacToe.getStatusBar().updateLabelStatus();
                        ticTacToe.getEngine().stop();
                        break;
                    default:
                        break;
                }
            });
            if (column == 2) {
                column = 0;
                row++;
            } else {
                column++;
            }
        }
    }

    public void resetCells() {
        buttonList.forEach(b -> b.setText(" "));
        boardGrid = new BoardGrid();
        setBoardStatus(BoardStatus.NOT_STARTED);
    }

    void enableAllCells() {
        if (ticTacToe.getCurrentPlayer().getLevel() != Level.HUMAN) {
            buttonList.forEach(b -> b.setEnabled(false));
        } else {
            buttonList.forEach(b -> b.setEnabled(true));
        }
    }

    void enableEmptyCells() {
        if (ticTacToe.getCurrentPlayer().getLevel() != Level.HUMAN) {
            buttonList.forEach(b -> b.setEnabled(false));
        } else {
            for (var btn : buttonList) {
                if (btn.getText().equals(" ")) {
                    btn.setEnabled(true);
                }
            }

        }
    }

    void disableAllCells() {
        buttonList.forEach(b -> b.setEnabled(false));
    }


    void updateBoardStatus() {
        boardStatus = gridStatusChecker.checkGridStatus();
    }

    public BoardStatus getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

    public BoardGrid getBoardGrid() {
        return boardGrid;
    }

    public GridStatusChecker getGridStatusChecker() {
        return gridStatusChecker;
    }

    public Set<BoardCell> getButtonList() {
        return buttonList;
    }
}
