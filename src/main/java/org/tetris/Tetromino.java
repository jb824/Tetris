package org.tetris;

public class Tetromino {
    private Shape shape;
    private int rotationState, x, y;

    public Tetromino(Shape shape, int x, int y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }
    public int getWidth() {
        return shape.getWidth();
    }

    public int getHeight() {
        return shape.getHeight();
    }

    public void moveLeft() {
        x--;
    }
    public void moveRight() {
        x++;
    }
    public void moveDown() {
        y--;
    }
    public Shape getShape() {
        return shape;
    }
    public void rotateClockwise() {


    }

}
