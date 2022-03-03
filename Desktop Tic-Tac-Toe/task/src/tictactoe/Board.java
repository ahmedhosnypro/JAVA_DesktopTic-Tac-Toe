package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    GridLayout boardLayout = new GridLayout(3, 3);

    //buttons
    JButton buttonA1;
    JButton buttonA2;
    JButton buttonA3;
    JButton buttonB1;
    JButton buttonB2;
    JButton buttonB3;
    JButton buttonC1;
    JButton buttonC2;
    JButton buttonC3;

    //initialize buttons and set names
    {
        buttonA1 = new JButton("A1");
        buttonA1.setName("ButtonA1");

        buttonA2 = new JButton("A2");
        buttonA2.setName("ButtonA2");

        buttonA3 = new JButton("A3");
        buttonA3.setName("ButtonA3");

        buttonB1 = new JButton("B1");
        buttonB1.setName("ButtonB1");

        buttonB2 = new JButton("B2");
        buttonB2.setName("ButtonB2");

        buttonB3 = new JButton("B3");
        buttonB3.setName("ButtonB3");

        buttonC1 = new JButton("C1");
        buttonC1.setName("ButtonC1");

        buttonC2 = new JButton("C2");
        buttonC2.setName("ButtonC2");

        buttonC3 = new JButton("C3");
        buttonC3.setName("ButtonC3");
    }

    public Board() {
        setLayout(boardLayout);
        addButtons();
    }

    private void addButtons() {
        add(buttonA3);
        add(buttonB3);
        add(buttonC3);

        add(buttonA2);
        add(buttonB2);
        add(buttonC2);

        add(buttonA1);
        add(buttonB1);
        add(buttonC1);
    }

}
