package org.tetris;
import java.awt.*;
import java.util.Random;

public class Tetromino {
    private Shape shape;
    private int rotationState;
    private int columns;
    private int rows;
    private Color color;
    private Tetromino tetromino;

    public Tetromino() {}
    public Tetromino(Shape shape, Color color, int rotationState, int columns, int rows) {
        this.shape = shape;
        this.color = color;
        this.rotationState = rotationState;
        this.columns = columns; // initial column
        this.rows = rows; // initial row
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
        columns--;
    }
    // TODO: add boundaries to prevent tetrominoes from falling off board
    public void moveRight() {
        columns++;
    }
    // TODO: add boundaries to prevent tetrominoes from falling off board
    public void moveDown() {
        if (rows < Board.getBoardHeight() - 1) {
            rows++;
        }
    }

    public Shape getShape() {
        return shape;
    }
    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }

}
