package org.tetris;
import java.awt.*;
import java.util.Random;

public class Tetromino {
    private Shape shape;
    private int rotationState;
    private int x;
    private int y;
    private Color color;

    public Tetromino(Shape shape, Color color, int rotationState, int x, int y) {
        this.shape = shape;
        this.color = color;
        this.rotationState = rotationState;
        this.x = 0; // initial column
        this.y = 0; // initial row
    }
    public int getWidth() {
        return shape.getWidth();
    }

    public int getHeight() {
        return shape.getHeight();
    }

    public void rotatingClockwise() {
        if (rotationState > 3) {
            rotationState = 0;
        }
        for (int i = 0; i < rotationState; i++) {
            shape.rotateClockwise();
        }
    }

    // TODO: add boundaries to prevent tetrominoes from falling off board
    public void moveLeft() {
        x--;
    }
    // TODO: add boundaries to prevent tetrominoes from falling off board
    public void moveRight() {
        x++;
    }
    // TODO: add boundaries to prevent tetrominoes from falling off board
    public void moveDown() {
        if (y < Board.getBoardHeight() - 1) {
            y++;
        }
    }

    public Shape getShape() {
        return shape;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
