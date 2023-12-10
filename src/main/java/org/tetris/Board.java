package org.tetris;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Cell[][] cells;
    private static int width = 10; // board dimensions
    private static int height = 20; // board dimensions
    private static int hiddenRows = 2;
    private static int cellSize = 24;
    private Tetris tetris;
    public Board(Tetris tetris) {
        this.tetris = tetris;
        this.cells = new Cell[getBoardHeight()][getBoardWidth()];

        // Initialize cells
        for (int i = 0; i < getBoardHeight(); i++) {
            for (int j = 0; j < getBoardWidth(); j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    public static int getBoardWidth() {
        return width;
    }
    public static int getBoardHeight() {
        return height;
    }
    public static int getHiddenRows() {return hiddenRows; }

    // removes tetrominoes from board by assigning null value;
    // consider renaming to clearBoard()
    public void clearLines() {
        for(int i = 0; i < getBoardHeight(); i++) {
            for(int j = 0; j < getBoardWidth(); j++) {
                cells[i][j] = null;
            }
        }
    }
    private boolean checkCollision() {
        Tetromino currentTetromino = tetris.getCurrentPiece();

        for (int i = 0; i < currentTetromino.getShape().getDimension(); i++) {
            for (int j = 0; j < currentTetromino.getShape().getDimension(); j++) {
                int boardX = currentTetromino.getX() + j;
                int boardY = currentTetromino.getY() + i;

                // Check if the indices are within bounds
                if (boardX >= 0 && boardX < getBoardWidth() && boardY >= 0 && boardY < getBoardHeight()) {
                    if (currentTetromino.getShape().getBlockAt(j, i) &&
                            isCellOccupied(boardX, boardY)) {
                        return true;  // Collision detected
                    }
                } else {
                    // Indices are out of bounds, consider it as a collision
                    return true;
                }
            }
        }

        return false;  // No collision
    }
    private Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public boolean isGameOver() {
        for (int i = 0; i < getBoardHeight(); i++) {
            if (tetris.getCurrentPiece().getY() != 0) {
                return true;
            }
        }
        return false;
    }

    // TODO: push blank row at top
    public void removeLine(int y) {
        if (y < 0 || y >= getBoardHeight()) {
            return;
        }

        while (y > 0) {
            // Copy row above to below for all rows
            System.arraycopy(cells[y - 1], 0, cells[y], 0, getBoardWidth());
            y--;
        }


//        int occupiedRow = 0;
//
//        for (int i = getBoardHeight() - 1; i >= 0; i--) {
//            boolean completeRow = true;
//
//            for (int j = 0; j < getBoardWidth(); j++) {
//                if (isCellOccupied(j, i) == )
//            }
//            board[i] = Tetrominoe.NoShape;
//        }
    }
    public boolean checkCollision() {
        Tetromino currentTetromino = tetris.getCurrentPiece();

        for (int i = 0; i < currentTetromino.getShape().getDimension(); i++) {
            for (int j = 0; j < currentTetromino.getShape().getDimension(); j++) {
                if (currentTetromino.getShape().getBlockAt(j, i) &&
                        (currentTetromino.getX() + j >= getBoardWidth() ||
                                currentTetromino.getY() + i >= getBoardHeight() ||
                                isCellOccupied(currentTetromino.getX() + j, currentTetromino.getY() + i))) {
                                    return true;  // Collision detected
                }
            }
        }

        return false;  // No collision
    }
    public void lockTetromino() {
        Tetromino currentTetromino = tetris.getCurrentPiece();

        for (int i = 0; i < currentTetromino.getShape().getDimension(); i++) {
            for (int j = 0; j < currentTetromino.getShape().getDimension(); j++) {
                if (currentTetromino.getShape().getBlockAt(j, i)) {
                    cells[currentTetromino.getX() + j][currentTetromino.getY() + i] = new Cell();
                }
            }
        }
        // Other logic, such as checking for completed lines and removing them
        // (This might be part of the updateBoard() method)
    }
    private void updateBoard() {
        repaint();  // Repaint the GUI to reflect the updated state
        // Other logic, such as checking for completed lines and removing them
    }
    public void update() {
        Tetromino currentTetromino = tetris.getCurrentPiece();
        currentTetromino.moveDown();

        revalidate(); // Ensures the layout manager recalculates layout
        repaint();    // Requests immediate repaint

        // Check for collisions and handle line clears
        if (checkCollision()) {
            // Revert the move if there's a collision
//            currentTetromino.moveUp();
            // Lock the tetromino in place
            lockTetromino();
        } else {
            updateBoard();
        }

        // Check for game over
        if (isGameOver()) {
            // Handle game over logic
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        g.setColor(Color.WHITE);
//        g.setFont(new Font("Consolas", Font.PLAIN, 28));
//        g.drawString() // points & level

        // draw background cells
        for(int x = 0; x < getBoardWidth(); x++) {
            for(int y = 0; y < getBoardHeight(); y++) {
                int cellX = x * cellSize;
                int cellY = y * cellSize;

                g.fillRect(cellX, cellY, cellSize, cellSize);
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine(0, cellY, getBoardWidth() * cellSize, cellY);  // Horizontal line
                g.drawLine(cellX, 0, cellX, getBoardHeight() * cellSize); // Vertical line
                g.setColor(Color.BLACK);
            }
        }

        Tetromino currentTetromino = tetris.getCurrentPiece();
        // Draw the tetromino
        if (currentTetromino.getShape().getType() != Shape.ShapeType.BLANK_SHAPE) {
            for (int i = 0; i < currentTetromino.getShape().getHeight(); i++) {

                for (int j = 0; j < currentTetromino.getShape().getWidth(); j++) {

                    if (currentTetromino.getShape().getBlockAt(j, i)) {
                        drawTetromino(g, (currentTetromino.getX() + j) * cellSize,
                                (currentTetromino.getY() - hiddenRows + i) * cellSize,
                                currentTetromino.getShape().getColor());
                    }
                }
            }
        }
    }

    private int cellWidth() {
        return (int) (getSize().getWidth() / getBoardWidth());
    }
    private int cellHeight() {
        return (int) (getSize().getHeight() / getBoardHeight());
    }

    private void drawTetromino(Graphics g, int x, int y, Color color) {

        Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

//        Color color = colors[type.getShape().ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, cellSize - 2, cellSize - 2);


//        g.setColor(color.brighter());
//        g.drawLine(x, y + cellHeight() - 1, x, y);
//        g.drawLine(x, y, x + cellWidth() - 1, y);
//
//        g.setColor(color.darker());
//        g.drawLine(x + 1, y + cellSize - 1,
//                x + cellSize - 1, y + cellSize - 1);
//        g.drawLine(x + cellSize - 1, y + cellSize - 1,
//                x + cellSize - 1, y + 1);
    }

}
