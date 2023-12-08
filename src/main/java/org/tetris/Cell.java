package org.tetris;

import java.awt.*;

public class Cell {
    private boolean occupied;
    private Color color;

    // returns true if cell occupied by tetromino
    public boolean isOccupied() {
        return occupied;
    }

    private Color getColor() {
        return color;
    }

    private void setColor (Color color) {
        this.color = color;
    }

    private void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

}
