package tictactoe;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);

        addBoard();

        setVisible(true);
    }

    private void addBoard() {
        Board board = new Board();
        board.setName("Board");
        add(board);
    }
}