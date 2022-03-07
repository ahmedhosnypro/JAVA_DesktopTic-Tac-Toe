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
                    text = String.format("The turn of %s Player (%c)",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
                case O_TURN:
                    text = String.format("The turn of %s Player (%c)",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
                    break;
                case X_WINS:
                case O_WINS:
                    text = String.format("The %s Player (%c) wins",
                            ticTacToe.getCurrentPlayer().getName(),
                            ticTacToe.getCurrentPlayer().getGameChar());
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