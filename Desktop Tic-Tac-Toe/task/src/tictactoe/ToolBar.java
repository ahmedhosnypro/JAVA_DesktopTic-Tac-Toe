package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ToolBar extends JPanel {
    TicTacToe ticTacToe;
    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    static final String robot = "Robot";
    static final String human = "Human";
    static final String start = "Start";
    static final String reset = "Reset";

    final Dimension buttonDimension = new Dimension(133, 50);
    final JButton buttonStartReset = new JButton(start);
    final JButton buttonPlayer1 = new JButton(human);
    final JButton buttonPlayer2 = new JButton(human);

    public ToolBar(String name, TicTacToe ticTacToe) {
        setName(name);
        setLayout(new GridLayout(1, 3));
        setBackground(Color.BLACK);
        setBorder(border);

        this.ticTacToe = ticTacToe;
        setButton(buttonStartReset, "ButtonStartReset");
        setButton(buttonPlayer1, "ButtonPlayer1");
        setButton(buttonPlayer2, "ButtonPlayer2");

        add(buttonPlayer1);
        add(buttonStartReset);
        add(buttonPlayer2);

        addActionListeners();
    }

    private void setButton(JButton button, String name) {
        button.setName(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);
        button.setBorder(border);
        button.setFont(new Font("", Font.BOLD, 15));
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
    }

    private void addActionListeners() {
        buttonStartReset.addActionListener(e -> {
            if (buttonStartReset.getText().equals(start)) {     //start
                buttonStartReset.setText(reset);
                ticTacToe.setCurrentPlayer(ticTacToe.getFstPlayer());
                ticTacToe.getStatusBar().updateLabelStatus();
                ticTacToe.getEngine().start();
            } else {        //Reset
                buttonStartReset.setText(start);
                ticTacToe.getBoard().resetCells();
                ticTacToe.getEngine().stop();
                ticTacToe.getStatusBar().updateLabelStatus();
            }

        });

        buttonPlayer1.addActionListener(e -> {
            if (buttonPlayer1.getText().equals(human)) {
                buttonPlayer1.setText(robot);
                ticTacToe.getFstPlayer().setName(robot);
                ticTacToe.getFstPlayer().setLevel(Level.HARD);
            } else if (buttonPlayer1.getText().equals(robot)) {
                buttonPlayer1.setText(human);
                ticTacToe.getFstPlayer().setName(human);
                ticTacToe.getFstPlayer().setLevel(Level.HUMAN);
            }
        });

        buttonPlayer2.addActionListener(e -> {
            if (buttonPlayer2.getText().equals(human)) {
                buttonPlayer2.setText(robot);
                ticTacToe.getSndPlayer().setName(robot);
                ticTacToe.getSndPlayer().setLevel(Level.HARD);
            } else if (buttonPlayer2.getText().equals(robot)) {
                buttonPlayer2.setText(human);
                ticTacToe.getSndPlayer().setName(human);
                ticTacToe.getSndPlayer().setLevel(Level.HUMAN);
            }
        });
    }
}
