package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class GameMenu extends JMenu {
    TicTacToe ticTacToe;

    final transient Border border = BorderFactory.createLineBorder(Color.BLACK);
    private final transient Font myFont = new Font("", Font.BOLD, 15);

    final transient Set<JMenuItem> menuItems = new LinkedHashSet<>();
    final JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
    final JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
    final JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
    final JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
    final JMenuItem menuExit = new JMenuItem("Exit");


    public GameMenu(String name, String text, TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        setName(name);
        setText(text);
        setBorder(border);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        addMenuItems();
        setMenuItems();
        addActionListeners();
    }

    void addMenuItems() {
        menuHumanHuman.setName("MenuHumanHuman");
        menuItems.add(menuHumanHuman);

        menuHumanRobot.setName("MenuHumanRobot");
        menuItems.add(menuHumanRobot);

        menuRobotHuman.setName("MenuRobotHuman");
        menuItems.add(menuRobotHuman);

        menuRobotRobot.setName("MenuRobotRobot");
        menuItems.add(menuRobotRobot);

        menuExit.setName("MenuExit");
        menuItems.add(menuExit);

        add(menuHumanHuman);
        add(menuHumanRobot);
        add(menuRobotHuman);
        add(menuRobotRobot);

        addSeparator();
        add(menuExit);
    }

    void setMenuItems() {
        menuItems.forEach(menuItem -> menuItem.setBackground(Color.BLACK));
        menuItems.forEach(menuItem -> menuItem.setForeground(Color.WHITE));
        menuItems.forEach(menuItem -> menuItem.setBorder(border));
        menuItems.forEach(menuItem -> menuItem.setFont(myFont));
    }

    void addActionListeners() {
        menuHumanHuman.addActionListener(e -> setPlayers(Level.HUMAN, Level.HUMAN));
        menuHumanRobot.addActionListener(e -> setPlayers(Level.HUMAN, Level.ROBOT));
        menuRobotHuman.addActionListener(e -> setPlayers(Level.ROBOT, Level.HUMAN));
        menuRobotRobot.addActionListener(e -> setPlayers(Level.ROBOT, Level.ROBOT));
        menuExit.addActionListener(e -> System.exit(0));
    }

    void setPlayers(Level fstPlayerLevel, Level sndPlayerLevel) {
        ticTacToe.getToolBar().buttonPlayer1.setText(fstPlayerLevel.getLevelName());
        ticTacToe.getToolBar().buttonPlayer2.setText(sndPlayerLevel.getLevelName());
        ticTacToe.getFstPlayer().setLevel(fstPlayerLevel);
        ticTacToe.getSndPlayer().setLevel(sndPlayerLevel);
        ticTacToe.getFstPlayer().setName(fstPlayerLevel.getLevelName());
        ticTacToe.getSndPlayer().setName(sndPlayerLevel.getLevelName());
        ticTacToe.getBoard().resetCells();
        ticTacToe.getToolBar().buttonStartReset.setText("Reset");
        ticTacToe.getEngine().start();
    }
}
