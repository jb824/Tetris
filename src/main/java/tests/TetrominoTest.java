package tests;

import org.junit.Test;
import org.tetris.Shape;
import org.tetris.Tetromino;

import java.awt.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TetrominoTest {
    @Test
    public void testRotatingClockwise() {
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        Tetromino tetrominoJ = new Tetromino(shapeJ, Color.BLUE, 3,0, 0);
        tetrominoJ.rotatingClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                { false, false, false},
                { true, true, true},
                {false, false, true},
        }, tetrominoJ.getShape().getBlocks());
    }

    @Test
    public void testMoveLeft() {
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        Tetromino tetrominoJ = new Tetromino(shapeJ, Color.BLUE, 0, 0, 0);
        int leftFourCells = -4;
        for (int i = 0; i > leftFourCells; i--) {
            tetrominoJ.moveLeft();
        }
        assertEquals(leftFourCells, tetrominoJ.getX());
    }

    @Test
    public void testMoveRight() {
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        Tetromino tetrominoJ = new Tetromino(shapeJ, Color.BLUE, 0, 0, 0);
        int rightFourCells = 4;
        for (int i = 0; i < rightFourCells; i++) {
            tetrominoJ.moveRight();
        }
        assertEquals(rightFourCells, tetrominoJ.getX());
    }

    @Test
    public void testMoveDown() {
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        Tetromino tetrominoJ = new Tetromino(shapeJ, Color.BLUE, 0, 0,0);
        int downTwenty = 20;
        for (int i = 0; i < downTwenty; i++) {
            tetrominoJ.moveDown();
        }
        assertEquals(downTwenty, tetrominoJ.getY());
    }
}
