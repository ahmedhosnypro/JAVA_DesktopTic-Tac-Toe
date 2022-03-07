package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatusBar extends JPanel {
    TicTacToe ticTacToe;
    final JLabel labelStatus = new JLabel("Game is not started");

    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    public StatusBar(String name, TicTacToe ticTacToe) {
        setName(name);
        setBackground(Color.ORANGE);

        this.ticTacToe = ticTacToe;
        setBorder(border);
        setFields();

        add(labelStatus);
    }

    private void setFields() {
        labelStatus.setName("LabelStatus");
        labelStatus.setForeground(Color.BLACK);
        labelStatus.setFont(new Font("", Font.BOLD, 15));
    }

    void updateLabelStatus() {
        String text = "";
        if (ticTacToe.getToolBar().buttonStartReset.getText().equals("Start")) {
            text = "Game is not started";
            setBackground(Color.ORANGE);
            labelStatus.setForeground(Color.BLACK);
        } else if (ticTacToe.getToolBar().buttonStartReset.getText().equals("Reset")) {
            var boardStatus = ticTacToe.getBoard().getBoardStatus();
            switch (boardStatus) {
                case NOT_STARTED:
                case X_TURN:
                case O_TURN:
                    text = String.format("The turn of %s Player (%c)",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
                    setBackground(boardStatus.getBackgroundColor());
                    labelStatus.setForeground(boardStatus.getForegroundColor());
                    break;
                case X_WINS:
                case O_WINS:
                    text = String.format("The %s Player (%c) wins",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
                    setBackground(boardStatus.getBackgroundColor());
                    labelStatus.setForeground(boardStatus.getForegroundColor());
                    break;
                case DRAW:
                    text = "Draw";
                    setBackground(boardStatus.getBackgroundColor());
                    labelStatus.setForeground(boardStatus.getForegroundColor());
                    break;
                default:
                    text = "Game in progress";
                    break;
            }
        }
        labelStatus.setText(text);
    }
}