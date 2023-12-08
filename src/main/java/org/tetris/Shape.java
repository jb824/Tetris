package org.tetris;

import java.awt.*;

public class Shape {
    private boolean[][] blocks;
    private Color color;
    private int dimension;
    private ShapeType type;

    // not all tetromineos have the same width!
    public Shape(ShapeType type, Color color) {
        this.type = type;
        this.color = color;
        initShape(type);
    }

    public enum ShapeType {
        O_SHAPE, I_SHAPE, L_SHAPE, J_SHAPE, S_SHAPE, Z_SHAPE, T_SHAPE
    }

    public static Shape createShape(ShapeType type, Color color) {
        return new Shape(type, color);
    }

    private void initShape(ShapeType type) {
        blocks = getBlocksForType(type);
    }

    public ShapeType getType() {
        return type;
    }

    private boolean[][] getBlocksForType(ShapeType type) {
        switch (type) {
            case O_SHAPE:
                blocks = new boolean[][]{
                        { // 0° rotation
                            true, true,
                            true, true
                        },
                        { // 90° rotation
                            true, true,
                            true, true
                        },
                        { // 180° rotation
                            true, true,
                            true, true
                        },
                        { // 270° rotation
                            true, true,
                            true, true
                        }
                };
                break;
            case I_SHAPE:
                blocks = new boolean[][]{
                        { // 0° rotation
                            false, false, false, false,
                            false, false, false, false,
                            true, true, true, true,
                            false, false, false, false
                        },
                        { // 90° rotation
                            false, true, false, false,
                            false, true, false, false,
                            false, true, false, false,
                            false, true, false, false
                        },
                        { // 180° rotation
                            false, false, false, false,
                            true, true, true, true,
                            false, false, false, false,
                            false, false, false, false
                        },
                        { // 270° rotation
                            false, false, true, false,
                            false, false, true, false,
                            false, false, true, false,
                            false, false, true, false
                        }
                };
                break;
            case L_SHAPE:
                blocks = new boolean[][]{
                    { // 0° rotation
                        false, true, false,
                        false, true, false,
                        false, true, true
                    },
                    { // 90° rotation
                        false, false, true,
                        true, true, true,
                        false, false, false
                    },
                    { // 180° rotation
                        true, true, false,
                        false, true, false,
                        false, true, false
                    },
                    { // 270° rotation
                        false, false, false,
                        true, true, true,
                        true, false, false
                    }
                };
                break;
            case J_SHAPE:
                blocks = new boolean[][]{
                    { // 0° rotation
                        false, true, false,
                        false, true, false,
                        true, true, false
                    },
                    { // 90° rotation
                        false, false, false,
                        true, true, true,
                        false, false, true
                    },
                    { // 180° rotation
                        false, true, true,
                        false, true, false,
                        false, true, false
                    },
                    { // 270° rotation
                        true, false, false,
                        true, true, true,
                        false, false, false
                    }
                };
                break;
            case S_SHAPE:
                blocks = new boolean[][] {
                    { // 0° rotation
                        true, false, false,
                        true, true, false,
                        false, true, false
                    },
                    { // 90° rotation
                        false, true, true,
                        true, true, false,
                        false, false, false
                    },
                    { // 180° rotation
                        false, true, false,
                        false, true, true,
                        false, false, true
                    },
                    { // 270° rotation
                        false, true, false,
                        false, true, true,
                        true, true, false
                    },
                };
                break;
            case Z_SHAPE:
                blocks = new boolean[][] {
                    { // 0° rotation
                        false, true, false,
                        true, true, false,
                        true, true, false
                    },
                    { // 90° rotation
                        true, true, false,
                        false, true, true,
                        false, false, false
                    },
                    { // 180° rotation
                        false, false, true,
                        false, true, true,
                        false, true, false
                    },
                    { // 270° rotation
                        true, false, false,
                        true, true, false,
                        false, true, true
                    }
                };
                break;
            case T_SHAPE:
                blocks = new boolean[][] {
                    { // 0° rotation
                        false, true, false,
                        false, true, true,
                        false, true, false
                    },
                    { // 90° rotation
                        false, false, false,
                        true, true, true,
                        false, true, false
                    },
                    {  // 180° rotation
                        false, true, false,
                        true, true, false,
                        false, true, false
                    },
                    {  // 270° rotation
                        false, true, false,
                        true, true, true,
                        false, false, false
                    },
                };
                break;
        }
        return blocks;
    }

    public int getWidth() {
        return blocks[0].length;
    }

    public int getHeight() {
        return blocks.length;
    }

    public Color getColor() {
        return color;
    }
    public void getRotationsCount() {

    }

    public void rotateClockwise() {
        boolean[][] rotateNinetyDegrees = new boolean[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                rotateNinetyDegrees[i][j] = blocks[getHeight() - j - 1][i];
            }
        }
    }

    public void rotateCounterClockwise() {
        boolean[][] rotateNinetyDegrees = new boolean[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                rotateNinetyDegrees[i][j] = blocks[i][getHeight() - j - 1];
            }
        }
    }
     /*
        Check if a block is present at the specified position within the cell.**
        @param x The x-coordinate within the cell.
        @param y The y-coordinate within the cell.
        @return True if a block is present at the specified position, false otherwise.
     */
    public boolean getBlockAt(int rotation, int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            return blocks[rotation][y * dimension + x];
        } else {
          return false;
        }
    }

}
