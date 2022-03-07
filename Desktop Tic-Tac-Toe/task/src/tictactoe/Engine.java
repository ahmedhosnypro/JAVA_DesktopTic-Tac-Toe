package tictactoe;

public class Engine {
    final TicTacToe ticTacToe;
    private final RobotEmulator robotEmulator;

    public Engine(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        robotEmulator = new RobotEmulator(ticTacToe);
    }

    void start() {
        ticTacToe.getBoard().enableAllCells();
        ticTacToe.getToolBar().buttonPlayer1.setEnabled(false);
        ticTacToe.getToolBar().buttonPlayer2.setEnabled(false);
        ticTacToe.getCurrentPlayer().play();
    }

    void stop() {
        ticTacToe.getBoard().disableAllCells();

        ticTacToe.getFstPlayer().stopPlaying();
        ticTacToe.getSndPlayer().stopPlaying();

        ticTacToe.getToolBar().buttonPlayer1.setEnabled(true);
        ticTacToe.getToolBar().buttonPlayer2.setEnabled(true);
        ticTacToe.setCurrentPlayer(ticTacToe.getFstPlayer());
    }

    public RobotEmulator getRobotEmulator() {
        return robotEmulator;
    }
}
