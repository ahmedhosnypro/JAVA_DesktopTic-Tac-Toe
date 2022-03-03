package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    final BorderLayout borderLayout = new BorderLayout();
    final StatusBar statusBar = new StatusBar("Status Bar", this);
    final Board board = new Board("Board", statusBar);

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLayout(borderLayout);

        addBoard();
        addStatusBar();

        setVisible(true);
    }

    private void addBoard() {
        add(board, BorderLayout.CENTER);
    }

    private void addStatusBar() {
        add(statusBar, BorderLayout.SOUTH);
    }
}