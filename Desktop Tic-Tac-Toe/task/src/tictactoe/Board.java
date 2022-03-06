package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedHashSet;

public class Board extends JPanel {
    TicTacToe ticTacToe;
    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    BoardStatus boardStatus = BoardStatus.NOT_STARTED;

    //buttons
    final LinkedHashSet<JButton> buttonList = new LinkedHashSet<>(); //list of buttons
    final JButton buttonA1 = new BoardCell("ButtonA1", this);
    final JButton buttonA2 = new BoardCell("ButtonA2", this);
    final JButton buttonA3 = new BoardCell("ButtonA3", this);
    final JButton buttonB1 = new BoardCell("ButtonB1", this);
    final JButton buttonB2 = new BoardCell("ButtonB2", this);
    final JButton buttonB3 = new BoardCell("ButtonB3", this);
    final JButton buttonC1 = new BoardCell("ButtonC1", this);
    final JButton buttonC2 = new BoardCell("ButtonC2", this);
    final JButton buttonC3 = new BoardCell("ButtonC3", this);


    transient BoardGrid boardGrid = new BoardGrid();
    final transient GridStatusChecker gridStatusChecker = new GridStatusChecker(this);

    public Board(String name, TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        setName(name);
        setLayout(new GridLayout(3, 3));
        setBorder(border);

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
    }

    private void addButtons() {
        for (var button : buttonList) {
            add(button);
        }

        int row = 0;
        int column = 0;
        for (var button : buttonList) {
            int finalRow = row;
            int finalColumn = column;
            button.addActionListener(e -> {
                if (button.getText().equals(" ")) {
                    char gameChar = ' ';
                    BoardStatus status = getBoardStatus();
                    switch (status) {
                        case X_TURN:
                        case NOT_STARTED:
                            gameChar = 'X';
                            break;
                        case O_TURN:
                            gameChar = 'O';
                            break;
                        default:
                            break;
                    }
                    boardGrid.setGrid(finalRow, finalColumn, gameChar);
                    ticTacToe.statusBar.updateLabelStatus();
                    button.setText(String.valueOf(gameChar));
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

    public BoardStatus getBoardStatus() {
        return gridStatusChecker.checkGridStatus();
    }

    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }
}