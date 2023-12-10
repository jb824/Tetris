package org.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisKeyAdapter extends KeyAdapter {
    private final Tetris tetris;

    public TetrisKeyAdapter(Tetris tetris) {
        this.tetris = tetris;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                tetris.getCurrentPiece().moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                tetris.getCurrentPiece().moveRight();
                break;
            case KeyEvent.VK_DOWN:
                tetris.getCurrentPiece().moveDown();
                break;
            case KeyEvent.VK_UP:
                tetris.getCurrentPiece().getShape().rotateCounterClockwise();
                break;
        }
    }
}

