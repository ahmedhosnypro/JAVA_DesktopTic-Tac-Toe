package tictactoe;

import java.awt.*;

public enum BoardStatus {
    NOT_STARTED(Color.RED, Color.BLACK),
    X_TURN(Color.MAGENTA, Color.BLACK),
    O_TURN(Color.CYAN, Color.BLACK),
    X_WINS(Color.ORANGE, Color.RED),
    O_WINS(Color.ORANGE, Color.blue),
    DRAW(Color.green, Color.BLACK);

    private final Color backgroundColor;
    private final Color foregroundColor;

    BoardStatus(Color backgroundColor, Color foregroundColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }
}
