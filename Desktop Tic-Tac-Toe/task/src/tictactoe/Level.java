package tictactoe;

public enum Level {
    HUMAN("Human"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    ROBOT("Robot");

    private final String levelName;

    Level(String name) {
        this.levelName = name;
    }

    public String getLevelName() {
        return levelName;
    }
}
