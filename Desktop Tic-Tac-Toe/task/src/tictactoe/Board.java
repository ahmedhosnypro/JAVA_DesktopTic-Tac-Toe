package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;

public class Board extends JPanel {
    GridLayout boardLayout = new GridLayout(3, 3);

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

    //add buttons to buttonList
    {
        buttonList.add(buttonA3);
        buttonList.add(buttonB3);
        buttonList.add(buttonC3);
        buttonList.add(buttonA2);
        buttonList.add(buttonB2);
        buttonList.add(buttonC2);
        buttonList.add(buttonA1);
        buttonList.add(buttonB1);
        buttonList.add(buttonC1);
    }


    BoardGrid boardGrid = new BoardGrid(this);
    StatusBar statusBar;
    final GridStatusChecker gridStatusChecker = new GridStatusChecker(this);

    final ActionListener buttonA3Listener = e -> {
        int row = getCellRow(buttonA3);
        int column = getCellColumn(buttonA3);

        if (buttonA3.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonA3.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonA2Listener = e -> {
        int row = getCellRow(buttonA2);
        int column = getCellColumn(buttonA2);

        if (buttonA2.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonA2.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonA1Listener = e -> {
        int row = getCellRow(buttonA1);
        int column = getCellColumn(buttonA1);

        if (buttonA1.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonA1.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonB3Listener = e -> {
        int row = getCellRow(buttonB3);
        int column = getCellColumn(buttonB3);

        if (buttonB3.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonB3.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonB2Listener = e -> {
        int row = getCellRow(buttonB2);
        int column = getCellColumn(buttonB2);

        if (buttonB2.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonB2.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonB1Listener = e -> {
        int row = getCellRow(buttonB1);
        int column = getCellColumn(buttonB1);

        if (buttonB1.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonB1.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonC3Listener = e -> {
        int row = getCellRow(buttonC3);
        int column = getCellColumn(buttonC3);

        if (buttonC3.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonC3.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonC2Listener = e -> {
        int row = getCellRow(buttonC2);
        int column = getCellColumn(buttonC2);

        if (buttonC2.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonC2.setText(String.valueOf(XO));
        }
    };
    final ActionListener buttonC1Listener = e -> {
        int row = getCellRow(buttonC1);
        int column = getCellColumn(buttonC1);

        if (buttonC1.getText().equals(" ")) {
            char XO = ' ';
            switch (getBoardStatus()) {
                case X_TURN:
                case NOT_STARTED:
                    XO = 'X';
                    break;
                case O_TURN:
                    XO = 'O';
                    break;
            }
            boardGrid.setGrid(row, column, XO);
            statusBar.updateLabelStatus();
            buttonC1.setText(String.valueOf(XO));
        }
    };

    public Board(String name, StatusBar statusBar) {
        this.statusBar = statusBar;
        setName(name);
        setLayout(boardLayout);
        addButtons();
    }

    private void addButtons() {
        add(buttonA3);
        add(buttonB3);
        add(buttonC3);
        add(buttonA2);
        add(buttonB2);
        add(buttonC2);
        add(buttonA1);
        add(buttonB1);
        add(buttonC1);

        buttonA3.addActionListener(buttonA3Listener);
        buttonA2.addActionListener(buttonA2Listener);
        buttonA1.addActionListener(buttonA1Listener);
        buttonB3.addActionListener(buttonB3Listener);
        buttonB2.addActionListener(buttonB2Listener);
        buttonB1.addActionListener(buttonB1Listener);
        buttonC3.addActionListener(buttonC3Listener);
        buttonC2.addActionListener(buttonC2Listener);
        buttonC1.addActionListener(buttonC1Listener);
    }

    public void resetCells() {
        buttonList.forEach(b -> b.setText(" "));
        boardGrid = new BoardGrid(this);
        setBoardStatus(BoardStatus.NOT_STARTED);
    }

    public BoardStatus getBoardStatus() {
        return gridStatusChecker.checkGridStatus();
    }

    public LinkedHashSet<JButton> getButtonList() {
        return buttonList;
    }

    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

    private int getCellRow(JButton cell) {
        int ret = -1;
        String name = cell.getName();
        switch (name.charAt(name.length() - 1)) {
            case '3':
                ret = 0;
                break;
            case '2':
                ret = 1;
                break;
            case '1':
                ret = 2;
                break;
        }
        return ret;
    }

    private int getCellColumn(JButton cell) {
        int ret = -1;
        String name = cell.getName();
        switch (name.charAt(name.length() - 2)) {
            case 'A':
                ret = 0;
                break;
            case 'B':
                ret = 1;
                break;
            case 'C':
                ret = 2;
                break;
        }
        ;
        return ret;
    }
}
