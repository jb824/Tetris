package org.tetris;

import javax.swing.*;

public class Board extends JPanel {

      private Cell[][] cells;

    private static int width, height; // board dimensions
    public static int getBoardWidth() {
        return width;
    }
    public static int getBoardHeight() {
        return height;
    }
    public void clearLines() {

    }
    public boolean isCellOccupied(int x, int y) {
        return cells[x][y].isOccupied();
    }

    public boolean isGameOver() {
        return true;
    }

    public void removeLine(int line) {

    }

    public void update() {

    }

}
