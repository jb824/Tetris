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
    public void clearBoard() {
        for(int i = 0; i < getBoardHeight(); i++) {
            for(int j = 0; j < getBoardWidth(); j++) {
                cells[i][j] = new Cell();  // Reset cell to a new instance
            }
        }
    }

    public boolean isCellOccupied(int columns, int rows) {
        // Check if the indices are within bounds
        if (columns >= 0 && columns < getBoardWidth() && rows >= 0 && rows < getBoardHeight()) {
            // Check if the cell is occupied
            return cells[rows][columns] != null && cells[rows][columns].isOccupied();
        } else {
            // Indices are out of bounds, consider the cell as not occupied
            return false;
        }
    }

    private Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public boolean isGameOver() {
        for (int i = 0; i < getBoardHeight(); i++) {
            if (tetris.getCurrentPiece().getRows() != 0) {
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
    }

    public void lockTetromino(Tetromino tetromino) {
        Tetromino currentTetromino = tetris.getCurrentPiece();

        for (int i = 0; i < currentTetromino.getShape().getDimension(); i++) {
            for (int j = 0; j < currentTetromino.getShape().getDimension(); j++) {
                if (currentTetromino.getShape().getBlockAt(j, i)) {
                    // Update the indices used to access the cells array
                    int boardX = currentTetromino.getColumns() + j;
                    int boardY = currentTetromino.getRows() + i;

                    // Check if the indices are within bounds
                    if (boardX >= 0 && boardX < getBoardWidth() && boardY >= 0 && boardY < getBoardHeight()) {
                        cells[boardY][boardX].setOccupied(true);
                        drawTetromino(getGraphics(), (tetromino.getColumns() + j) * cellSize,
                                (tetromino.getRows() - hiddenRows + i) * cellSize,
                                tetromino.getShape().getColor());
                        repaint();
                    }
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 28));
//        g.drawString(); // points & level

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
                        drawTetromino(g, (currentTetromino.getColumns() + j) * cellSize,
                                (currentTetromino.getRows() - hiddenRows + i) * cellSize,
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
        g.setColor(color);
        g.fillRect(x + 1, y + 1, cellSize - 2, cellSize - 2);
    }


}
