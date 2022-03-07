package tictactoe;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ApplicationRunner {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        FlatLightLaf.setup(); //setting the look and feel
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeAndWait(TicTacToe::new);
    }
}
