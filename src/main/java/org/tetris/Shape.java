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
        BLANK_SHAPE, O_SHAPE, I_SHAPE, L_SHAPE, J_SHAPE, S_SHAPE, Z_SHAPE, T_SHAPE
    }

    public static Shape createShape(ShapeType type, Color color) {
        return new Shape(type, color);
    }

    private void initShape(ShapeType type) {
        blocks = getBlocksForType(type);
        dimension = blocks.length;
    }

    public ShapeType getType() {
        return type;
    }

    public int getDimension() {
        return dimension;
    }
    protected boolean[][] getBlocksForType(ShapeType type) {
        switch (type) {
            case BLANK_SHAPE:
                blocks = new boolean[][]{
                        {false, false},
                        {false, false}
                };
                break;
            case O_SHAPE:
                blocks = new boolean[][]{
                    {true, true},
                    {true, true},
                };
                break;
            case I_SHAPE:
                blocks = new boolean[][]{

                    {false, false, false, false},
                    {false, false, false, false},
                    {false, false, false, false},
                    {true, true, true, true},
                };
                break;
            case L_SHAPE:
                blocks = new boolean[][]{
                    {false, true, false},
                    {false, true, false},
                    {false, true, true}
                };
                break;
            case J_SHAPE:
                blocks = new boolean[][]{
                    { false, true, false},
                    { false, true, false},
                    {true, true, false},
                };
                break;
            case S_SHAPE:
                blocks = new boolean[][] {
                     // 0° rotation
                    {true, false, false},
                    {true, true, false},
                    {false, true, false},
                };
                break;
            case Z_SHAPE:
                blocks = new boolean[][] {
                     // 0° rotation
                    {false, true, false},
                    {true, true, false},
                    {true, false, false},
                };
                break;
            case T_SHAPE:
                blocks = new boolean[][] {
                    {false, true, false},
                    {false, true, true},
                    {false, true, false},
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
    public boolean[][] getBlocks() {
        return blocks;
    }

    public void rotateClockwise() {
        int height = this.getHeight();
        int width = this.getWidth();

        // Transpose and find the symmetrical reflection in place
        for (int i = 0; i < height; i++) {
            for (int j = i + 1; j < width; j++) {
                boolean temp = blocks[i][j];
                blocks[i][j] = blocks[j][i];
                blocks[j][i] = temp;
            }
        }

        // Reverse each row to achieve 90° rotation
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width / 2; j++) {
                boolean temp = blocks[i][j];
                blocks[i][j] = blocks[i][width - 1 - j];
                blocks[i][width - 1 - j] = temp;
            }
        }
    }

    public void rotateCounterClockwise() {
        int height = this.getHeight();
        int width = this.getWidth();

        // Reverse each row to achieve 90° rotation
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width / 2; j++) {
                boolean temp = blocks[i][j];
                blocks[i][j] = blocks[i][width - 1 - j];
                blocks[i][width - 1 - j] = temp;
            }
        }

        // Transpose and find the symmetrical reflection in place
        for (int i = 0; i < height; i++) {
            for (int j = i + 1; j < width; j++) {
                boolean temp = blocks[i][j];
                blocks[i][j] = blocks[j][i];
                blocks[j][i] = temp;
            }
        }
    }
     /*
        Check if a block is present at the specified position within the cell.**
        @param x The x-coordinate within the cell.
        @param y The y-coordinate within the cell.
        @return True if a block is present at the specified position, false otherwise.
     */
    public boolean getBlockAt(int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            return blocks[x][y];
        } else {
          return false;
        }
    }

}
