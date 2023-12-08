package tests;

import org.junit.Test;
import org.tetris.Shape;
import java.awt.*;
import static org.junit.Assert.assertArrayEquals;

public class ShapeTest {

    @Test
    public void testRotateClockwise() {
        // tetromino shape-J
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        shapeJ.rotateClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                { true, false, false},
                { true, true, true},
                {false, false, false},
        }, shapeJ.getBlocks());

        // tetromino shape-L
        Shape.ShapeType typeL = Shape.ShapeType.L_SHAPE;
        Shape shapeL = new Shape(typeL, Color.RED);
        shapeL.rotateClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                {false, false, false},
                {true, true, true},
                {true, false, false}
        }, shapeL.getBlocks());

        // tetromino shape-S
        Shape.ShapeType typeS = Shape.ShapeType.S_SHAPE;
        Shape shapeS = new Shape(typeS, Color.GREEN);
        shapeS.rotateClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                {false, true, true},
                {true, true, false},
                {false, false, false},
        }, shapeS.getBlocks());

        // tetromino shape-Z
        Shape.ShapeType typeZ = Shape.ShapeType.Z_SHAPE;
        Shape shapeZ = new Shape(typeZ, Color.ORANGE);
        shapeZ.rotateClockwise();
        assertArrayEquals(new boolean[][]{
                {true, true, false},
                {false, true, true},
                {false, false, false}
        }, shapeZ.getBlocks());

        // tetromino shape-I
        Shape.ShapeType typeI = Shape.ShapeType.I_SHAPE;
        Shape shapeI = new Shape(typeI, Color.CYAN);
        shapeI.rotateClockwise();
        assertArrayEquals(new boolean[][]{
                {false, true, false, false},
                {false, true, false, false},
                {false, true, false, false},
                {false, true, false, false}
        }, shapeI.getBlocks());

        // tetromino shape-O
        Shape.ShapeType typeO = Shape.ShapeType.O_SHAPE;
        Shape shapeO = new Shape(typeO, Color.YELLOW);
        shapeO.rotateClockwise();
        assertArrayEquals(new boolean[][]{
                { true, true},
                {true, true},
        }, shapeO.getBlocks());

        // tetromino shape-T
        Shape.ShapeType typeT = Shape.ShapeType.T_SHAPE;
        Shape shapeT = new Shape(typeT, Color.PINK);
        shapeT.rotateClockwise();
        assertArrayEquals(new boolean[][]{
                {false, false, false},
                {true, true, true},
                {false, true, false}
        }, shapeT.getBlocks());
    }
    @Test
    public void testCounterClockwise() {
        // tetromino shape-J
        Shape.ShapeType typeJ = Shape.ShapeType.J_SHAPE;
        Shape shapeJ = new Shape(typeJ, Color.BLUE);
        shapeJ.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                {false, false, false},
                {true, true, true},
                {false, false, true},
        }, shapeJ.getBlocks());

        // tetromino shape-L
        Shape.ShapeType typeL = Shape.ShapeType.L_SHAPE;
        Shape shapeL = new Shape(typeL, Color.RED);
        shapeL.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                {false, false, true},
                {true, true, true},
                {false, false, false},
        }, shapeL.getBlocks());

          // tetromino shape-S
        Shape.ShapeType typeS = Shape.ShapeType.S_SHAPE;
        Shape shapeS = new Shape(typeS, Color.GREEN);
        shapeS.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{ // 90° rotation clockwise
                {false, false, false},
                {false, true, true},
                {true, true, false},
        }, shapeS.getBlocks());

        // tetromino shape-Z
        Shape.ShapeType typeZ = Shape.ShapeType.Z_SHAPE;
        Shape shapeZ = new Shape(typeZ, Color.ORANGE);
        shapeZ.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{
                {false, false, false},
                {true, true, false},
                {false, true, true},
        }, shapeZ.getBlocks());

        // tetromino shape-I
        Shape.ShapeType typeI = Shape.ShapeType.I_SHAPE;
        Shape shapeI = new Shape(typeI, Color.CYAN);
        shapeI.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{
                {false, false, true, false},
                {false, false, true, false},
                {false, false, true, false},
                {false, false, true, false}
        }, shapeI.getBlocks());

        // tetromino shape-O
        Shape.ShapeType typeO = Shape.ShapeType.O_SHAPE;
        Shape shapeO = new Shape(typeO, Color.YELLOW);
        shapeO.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{
                {true, true},
                {true, true},
        }, shapeO.getBlocks());

        // tetromino shape-T
        Shape.ShapeType typeT = Shape.ShapeType.T_SHAPE;
        Shape shapeT = new Shape(typeT, Color.PINK);
        shapeT.rotateCounterClockwise();
        assertArrayEquals(new boolean[][]{
                {false, true, false},
                {true, true, true},
                {false, false, false}
        }, shapeT.getBlocks());

    }

}