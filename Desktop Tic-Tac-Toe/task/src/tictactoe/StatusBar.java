package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StatusBar extends JPanel {
    final JLabel labelStatus = new JLabel("Game is not started");
    final JButton buttonReset = new JButton("Reset");
    final BorderLayout borderLayout = new BorderLayout();

    TicTacToe ticTacToe;

    final ActionListener buttonResetActionListener = e -> {
        ticTacToe.board.resetCells();
        updateLabelStatus();
    };

    {
        labelStatus.setName("LabelStatus");
        buttonReset.setName("ButtonReset");
    }

    public StatusBar(String name, TicTacToe ticTacToe) {
        setLayout(borderLayout);
        setName(name);
        this.ticTacToe = ticTacToe;

        add(labelStatus, BorderLayout.WEST);
        add(buttonReset, BorderLayout.EAST);

        buttonReset.addActionListener(buttonResetActionListener);
    }

    void updateLabelStatus() {
        String text = "";
        switch (ticTacToe.board.getBoardStatus()) {
            case NOT_STARTED:
                text = "Game is not started";
                break;
            case X_TURN:
            case O_TURN:
                text = "Game in progress";
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
        }
        labelStatus.setText(text);
    }
}
