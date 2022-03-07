package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TicTacToe extends JFrame {
    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);
    final Dimension dimension = new Dimension(450, 450);

    private final ToolBar toolBar = new ToolBar("Tool Bar", this);
    private final Board board = new Board("Board", this);
    private final StatusBar statusBar = new StatusBar("Status Bar", this);

    private final transient Engine engine = new Engine(this);
    private final transient Player fstPlayer = new Player(this, "Human", Level.HUMAN, 'X');
    private final transient Player sndPlayer = new Player(this, "Human", Level.HUMAN, 'O');
    transient Player currentPlayer = fstPlayer;


    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 450);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(border);
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.BLACK);
        GameMenu gameMenu = new GameMenu("MenuGame", "Game", this);
        menuBar.add(gameMenu);

        add(toolBar, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void switchPlayer() {
        if (currentPlayer.equals(fstPlayer)) {
            currentPlayer = sndPlayer;
        } else {
            currentPlayer = fstPlayer;
        }
        getStatusBar().updateLabelStatus();
        if (currentPlayer.getLevel() != Level.HUMAN) {
            currentPlayer.play();
        }
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    public Player getFstPlayer() {
        return fstPlayer;
    }

    public Player getSndPlayer() {
        return sndPlayer;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}