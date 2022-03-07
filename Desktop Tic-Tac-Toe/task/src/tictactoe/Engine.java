package tictactoe;

public class Engine {
    final TicTacToe ticTacToe;
    private final RobotEmulator robotEmulator;

    public Engine(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        robotEmulator = new RobotEmulator(ticTacToe);
    }

    void start() {
        ticTacToe.setCurrentPlayer(ticTacToe.getFstPlayer());
        ticTacToe.getBoard().enableAllCells();
        ticTacToe.getToolBar().buttonPlayer1.setEnabled(false);
        ticTacToe.getToolBar().buttonPlayer2.setEnabled(false);
        ticTacToe.getCurrentPlayer().play();
    }

    void stop() {
        ticTacToe.getBoard().disableAllCells();
        ticTacToe.getToolBar().buttonPlayer1.setEnabled(true);
        ticTacToe.getToolBar().buttonPlayer2.setEnabled(true);
        ticTacToe.setCurrentPlayer(ticTacToe.getFstPlayer());
    }

    public RobotEmulator getRobotEmulator() {
        return robotEmulator;
    }
}
