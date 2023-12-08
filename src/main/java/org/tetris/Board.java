package org.tetris;

public class Board {

      private Cell[][] cells;

    private static int width, height; // board dimensions
    public static int getWidth() {
        return width;
    }
    public static int getHeight() {
        return height;
    }
    public void clearLines() {

    }
    public boolean isCellOccupied(int x, int y) {
        return cells[x][y].isOccupied();
    }

    public boolean isGameOver() {

    }

    public void removeLine(int line) {

    }

    public void update() {

    }

}
