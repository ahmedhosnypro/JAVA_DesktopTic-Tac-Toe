package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class BoardCell extends JButton {
    TicTacToe ticTacToe;
    final transient Border whiteLine = BorderFactory.createLineBorder(Color.DARK_GRAY);


    public BoardCell(String name, TicTacToe ticTacToe) {
        super(" ");
        this.ticTacToe = ticTacToe;
        setName(name);
        setBackground(Color.BLACK);
        setForeground(Color.LIGHT_GRAY);
        setFont(new Font("", Font.BOLD, 100));
        setFocusPainted(false);
        setEnabled(false);
        setBorder(whiteLine);
    }

    void setActionListener() {
        addActionListener(e -> {
            if (getText().equals(" ")) {
                char gameChar = ' ';
                BoardStatus status = ticTacToe.getBoard().getBoardStatus();
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
                ticTacToe.getBoard().boardGrid.setGrid(gameChar, getCellRow(), getCellColumn());
                ticTacToe.getStatusBar().updateLabelStatus();
                setText(String.valueOf(gameChar));
            }
        });
    }

    private int getCellRow() {
        switch (getName().charAt(getName().length() - 1)) {
            case '3':
                return 0;
            case '2':
                return 1;
            case '1':
                return 2;
            default:
                return -1;
        }
    }

    private int getCellColumn() {
        switch (getName().charAt(getName().length() - 2)) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            default:
                return -1;
        }
    }
}