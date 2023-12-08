package org.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisKeyListener extends KeyAdapter {
    private Tetromino currentTetromino;

    public TetrisKeyListener(Tetromino currentTetromino) {
        this.currentTetromino = currentTetromino;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                currentTetromino.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                currentTetromino.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                currentTetromino.moveDown();
                break;
            // Handle other keys if needed...
        }
    }
}

