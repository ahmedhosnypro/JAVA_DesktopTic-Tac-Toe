package tictactoe;

import javax.swing.*;
import java.awt.*;

public class BoardCell extends JButton {
    Board board;
    int row;
    int column;


    public BoardCell(String name, Board board) {
        super(" ");
        this.board = board;
        setName(name);

        setFont(new Font("", Font.BOLD, 100));
        setFocusPainted(false);
    }

}
