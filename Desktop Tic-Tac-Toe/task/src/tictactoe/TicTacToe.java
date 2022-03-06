package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    final Dimension dimension = new Dimension(450, 450);
    final ToolBar toolBar = new ToolBar("Tool Bar", this);
    final Board board = new Board("Board", this);
    final StatusBar statusBar = new StatusBar("Status Bar", this);


    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 450);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setLayout(new BorderLayout());

        add(toolBar, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }
}