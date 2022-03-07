package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGrid {
    private final List<List<Character>> grid = new ArrayList<>();
    private final List<Character> mainDiagonal = new ArrayList<>();
    private final List<Character> sideDiagonal = new ArrayList<>();
    private final List<List<Character>> rotatedGrid = new ArrayList<>();
    private List<List<Character>> sides = new ArrayList<>();


    BoardGrid() {
        for (int row = 0; row < 3; row++) {
            grid.add(new ArrayList<>());
            rotatedGrid.add(new ArrayList<>());
            for (int column = 0; column < 3; column++) {
                grid.get(row).add(' ');
            }
        }
        setRotatedGrid();
        setDiagonal1();
        setDiagonal2();
        setSides();
    }

    public void setGrid(char gameChar, int row, int column) {
        grid.get(row).set(column, gameChar);
        setRotatedGrid();
        setDiagonal1();
        setDiagonal2();
        setSides();
    }

    void setRotatedGrid() {
        for (int row = 0; row < 3; row++) {
            rotatedGrid.get(row).clear();
            for (int column = 0; column < 3; column++) {
                rotatedGrid.get(row).add(column, grid.get(column).get(row));
            }
        }
    }

    void setDiagonal1() {
        mainDiagonal.clear();
        for (int row = 0; row < 3; row++) {
            mainDiagonal.add(row, grid.get(row).get(row));
        }
    }

    void setDiagonal2() {
        sideDiagonal.clear();
        sideDiagonal.add(0, grid.get(0).get(2));
        sideDiagonal.add(1, grid.get(1).get(1));
        sideDiagonal.add(2, grid.get(2).get(0));
    }

    public void setSides() {
        sides = List.of(mainDiagonal, sideDiagonal, grid.get(0),
                grid.get(1), grid.get(2), rotatedGrid.get(0),
                rotatedGrid.get(1), rotatedGrid.get(2));
    }

    public List<List<Character>> getGrid() {
        return grid;
    }

    public List<List<Character>> getSides() {
        return sides;
    }
}