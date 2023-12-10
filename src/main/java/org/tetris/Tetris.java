package org.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tetris extends JFrame {
    private Tetromino currentPiece;
    private JLabel statusbar;
    private Board board;
    private int score;
    private Timer timer;
    private boolean tetrominoLanded = false;
    public Tetris() {
        initUI();
        startGame();

        TetrisKeyAdapter keyAdapter = new TetrisKeyAdapter(this);
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    private void initUI() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);


        setTitle("Tetris");
        setSize(241, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {
        return statusbar;
    }

    void startGame() {
        int initialX = Board.getBoardWidth() / 2;
        int initialY = 0;

        board = new Board(this);
        add(board);

        // Set new random shape
        getRandomShape();
        currentPiece.setColumns(initialX);
        currentPiece.setRows(initialY);

        Timer timer = new Timer(500, e -> {
            // Move the piece down until it reaches the bottom or collides
            if (currentPiece.getRows() < Board.getBoardHeight() - Board.getHiddenRows()) {
                currentPiece.moveDown();
                board.repaint();
            } else {
                // fix tetromino in place
                board.lockTetromino(currentPiece);

                // Repaint the board
                board.repaint();
            }
        });

        timer.start();
    }

    public Tetromino getCurrentPiece() {
        return currentPiece;
    }
    public void getRandomShape() {
        Random random = new Random();
        int newTetromino = Math.abs(random.nextInt()) % 7 + 1;
        int randomRotationState = Math.abs(random.nextInt()) % 4 + 1;


        switch (newTetromino) {
            case 1:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.L_SHAPE,
                        new Color(204, 204, 102)),
                        new Color(204, 204, 102),
                        randomRotationState,
                        Board.getBoardWidth() / 2,
                        0
                ); break;
            case 2:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.J_SHAPE,
                        new Color(204, 102, 102)),
                        new Color(204, 102, 102),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
            case 3:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.I_SHAPE,
                        new Color(102, 204, 204)),
                        new Color(102, 204, 204),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
            case 4:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.O_SHAPE,
                        new Color(218, 170, 0)),
                        new Color(218, 170, 0),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
            case 5:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.S_SHAPE,
                        new Color(102, 204, 102)),
                        new Color(102, 204, 102),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
            case 6:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.Z_SHAPE,
                        new Color(204, 102, 204)),
                        new Color(204, 102, 204),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
            case 7:
                currentPiece = new Tetromino(
                        new Shape(Shape.ShapeType.T_SHAPE,
                        new Color(102, 102, 204)),
                        new Color(102, 102, 204),
                        randomRotationState,
                        getX(),
                        getY()
                ); break;
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }


}
