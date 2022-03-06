package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    TicTacToe ticTacToe;
    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);

    final Dimension buttonDimension = new Dimension(133, 50);
    final JButton buttonStartReset = new JButton("Start");
    final JButton buttonPlayer1 = new JButton("Human");
    final JButton buttonPlayer2 = new JButton("Human");

    final transient ActionListener buttonResetActionListener = e -> {
        ticTacToe.board.resetCells();
        ticTacToe.statusBar.updateLabelStatus();
    };

    public ToolBar(String name, TicTacToe ticTacToe) {
        setName(name);
        setLayout(new GridLayout(1, 3));
        setBackground(Color.BLACK);
        setBorder(border);

        this.ticTacToe = ticTacToe;
        setButton(buttonStartReset);
        setButton(buttonPlayer1);
        setButton(buttonPlayer2);

        add(buttonPlayer1);
        add(buttonStartReset);
        add(buttonPlayer2);

        buttonStartReset.addActionListener(buttonResetActionListener);
    }

    private void setButton(JButton button) {
        button.setName("ButtonReset");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);
        button.setBorder(border);
        button.setFont(new Font("", Font.BOLD, 15));
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
    }
}
