package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BoardCell extends JButton {
    Board board;
    final transient Border whiteLine = BorderFactory.createLineBorder(Color.DARK_GRAY);


    public BoardCell(String name, Board board) {
        super(" ");
        this.board = board;
        setName(name);
        setBackground(Color.BLACK);
        setForeground(Color.LIGHT_GRAY);
        setFont(new Font("", Font.BOLD, 100));
        setFocusPainted(false);

        setBorder(whiteLine);
    }
}