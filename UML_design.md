+---------------------------------------------+
|                  TetrisGame                  |
+---------------------------------------------+
| - board: Board                              |
| - currentPiece: Tetromino                   |
| - score: int                                |
+---------------------------------------------+
| + startGame(): void                         |
| + moveLeft(): void                          |
| + moveRight(): void                         |
| + rotate(): void                            |
| + drop(): void                              |
| + updateScore(): void                       |
| + isGameOver(): boolean                     |
+---------------------------------------------+

+---------------------------------------------+
|                    Board                    |
+---------------------------------------------+
| - cells: Cell[][]                           |
| - width: int                                |
| - height: int                               |
+---------------------------------------------+
| + clearLines(): void                        |
| + isCellOccupied(x: int, y: int): boolean   |
| + isGameOver(): boolean                     |
| + removeLine(line: int): void               |
| + update(): void                            |
+---------------------------------------------+

+---------------------------------------------+
|                 Tetromino                   |
+---------------------------------------------+
| - shape: Shape                              |
| - rotationState: int                        |
| - x: int                                    |
| - y: int                                    |
+---------------------------------------------+
| + moveLeft(): void                          |
| + moveRight(): void                         |
| + rotateClockwise(): void                   |
| + rotateCounterclockwise(): void            |
| + moveDown(): void                          |
| + getShape(): Shape                         |
+---------------------------------------------+

+---------------------------------------------+
|                    Shape                    |
+---------------------------------------------+
| - blocks: boolean[][]                       |
| - color: Color                              |
| - dimension: int                             |
+---------------------------------------------+
| + getWidth(): int                           |
| + getHeight(): int                          |
| + rotateClockwise(): void                   |
| + rotateCounterclockwise(): void            |
| + getBlockAt(x: int, y: int): boolean
| + getType(): int
+---------------------------------------------+

+---------------------------------------------+
|                    Cell                     |
+---------------------------------------------+
| - occupied: boolean                         |
| - color: Color                              |
+---------------------------------------------+
| + isOccupied(): boolean                     |
| + getColor(): Color                         |
| + setColor(color: Color): void              |
| + setOccupied(occupied: boolean): void      |
+---------------------------------------------+

- TetrisGame represents the overall game and manages the game state, such as the current board, the current piece, and the player's score. 
- Board represents the game board with its cells and is responsible for clearing lines, checking if a cell is occupied, and updating the board. 
- Tetromino represents the individual pieces in the game and manages their movement and rotation. 
  - In this class, rotateClockwise() and rotateCounterclockwise() are responsible for rotating the entire tetromino. 
    The Tetromino class manages the position (x and y coordinates) of the tetromino on the game board, and when a rotation 
    is requested, it adjusts these coordinates accordingly. 
  - These methods typically involve manipulating the internal state of the Tetromino instance by updating the rotation 
    state and, if necessary, the position of the tetromino.
- Shape represents the shape of a tetromino and manages the logic for rotating the shape.
  - The rotateClockwise() and rotateCounterclockwise() methods in this class are responsible for rotating the shape of the 
    tetromino without considering its position on the game board. The Shape class represents the static shape of a tetromino, 
    and these methods define how the shape itself should rotate.
  - The Shape class provides the logic for rotating the blocks within the shape without dealing with the tetromino's actual 
    position. It is concerned with the arrangement of blocks relative to the center of rotation.
 - Cell represents the individual cells on the game board, tracking whether they are occupied and their color.

You can add more details, methods, and attributes based on your specific implementation and requirements. Additionally, 
you may consider creating additional classes for handling GUI with JSwing and I/O files for saving and loading game states.