package tictactoe;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Player {
    Timer timer;
    TicTacToe ticTacToe;
    private String name;
    private Level level;
    private final char gameChar;

    public Player(TicTacToe ticTacToe, String name, Level level, char gameChar) {
        this.ticTacToe = ticTacToe;
        this.name = name;
        this.level = level;
        this.gameChar = gameChar;
    }

    void play() {
        if (level != Level.HUMAN) {
            timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    int[] cellCoord = ticTacToe.getEngine().getRobotEmulator().chooseCell();
                    String buttonName = ticTacToe.getEngine().getRobotEmulator().getButtonName(cellCoord);
                    BoardCell cell = ticTacToe.getEngine().getRobotEmulator().getButton(buttonName);
                    ticTacToe.getBoard().getBoardGrid()
                            .setGrid(ticTacToe.getCurrentPlayer().getGameChar(),
                                    cellCoord[0], cellCoord[1]);
                    cell.setText(String.valueOf(ticTacToe.getCurrentPlayer().getGameChar()));
                    cell.setEnabled(false);
                    ticTacToe.getBoard().updateBoardStatus();
                    switch (ticTacToe.getBoard().getBoardStatus()) {
                        case X_TURN:
                        case O_TURN:
                            ticTacToe.switchPlayer();
                            ticTacToe.getStatusBar().updateLabelStatus();
                            ticTacToe.getBoard().enableEmptyCells();
                            break;
                        case X_WINS:
                        case O_WINS:
                        case DRAW:
                            ticTacToe.getStatusBar().updateLabelStatus();
                            ticTacToe.getEngine().stop();
                            break;
                        default:
                            break;
                    }
                }
            };

            LocalDateTime timeToExecute = LocalDateTime.now().plusSeconds(3);
            Date execTime = Date.from(timeToExecute.atZone(ZoneId.systemDefault()).toInstant());
            timer.schedule(task, execTime);
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public char getGameChar() {
        return gameChar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void stopPlaying() {
        if(Objects.nonNull(timer)) {
            timer.cancel();
        }
    }
}
