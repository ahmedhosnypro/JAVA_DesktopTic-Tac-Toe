package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static tictactoe.BoardStatus.X_TURN;

public class StatusBar extends JPanel {
    TicTacToe ticTacToe;
    final JLabel labelStatus = new JLabel("Game is not started");

    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    public StatusBar(String name, TicTacToe ticTacToe) {
        setName(name);
        setBackground(Color.BLACK);

        this.ticTacToe = ticTacToe;
        setBorder(border);
        setFields();

        add(labelStatus);
    }

    private void setFields() {
        labelStatus.setName("LabelStatus");
        labelStatus.setBackground(Color.BLACK);
        labelStatus.setForeground(Color.LIGHT_GRAY);
        labelStatus.setFont(new Font("", Font.BOLD, 15));
    }

    void updateLabelStatus() {
        String text = "";
        if (ticTacToe.getToolBar().buttonStartReset.getText().equals("Start")) {
            text = "Game is not started";
        } else if (ticTacToe.getToolBar().buttonStartReset.getText().equals("Reset")) {
            switch (ticTacToe.getBoard().getBoardStatus()) {
                case NOT_STARTED:
                case X_TURN:
                case O_TURN:
                    text = String.format("The turn of %s Player(%c)",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
                    break;
                case X_WINS:
                    text = "X wins";
                    break;
                case O_WINS:
                    text = "O wins";
                    break;
                case DRAW:
                    text = "Draw";
                    break;
                default:
                    text = "Game in progress";
                    break;
            }
        }
        labelStatus.setText(text);
    }
}