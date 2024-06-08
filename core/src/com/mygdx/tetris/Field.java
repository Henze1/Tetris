package com.mygdx.tetris;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Field {
    public Texture borderTexture;
    public Texture freeSpaceTexture;
    private static int HEIGHT = 22;
    private static int WIDTH = 14;

    private final Texture[][] field = new Texture[HEIGHT][WIDTH];
    Field() {
        borderTexture = new Texture("data/7263.png");
        freeSpaceTexture = new Texture("data/7262.png");

        for (int row = 0; row < HEIGHT - 1; row++) {
            for (int col = 1; col < WIDTH - 1; col++) {
                field[row][col] = freeSpaceTexture;
            }
        }



        for (int row = 0; row < HEIGHT; row++) {
            field[row][0] = borderTexture;
            field[row][WIDTH - 1] = borderTexture;
            if (row == 21) {
                for (int col = 0; col < 14; col++) {
                    field[HEIGHT - 1][col] = borderTexture;
                }
            }
        }
    }

    public void draw(Batch batch, Texture[][] field) {
        final int squareSize = 49;
        int matrixHeight = HEIGHT;
        int matrixWidth = WIDTH;
        int startX = 615;
        int startY = 30;

        for (int row = 0; row < matrixHeight; row++) {
            for (int col = 0; col < matrixWidth; col++) {
                if (row == matrixHeight - 1 || col == 0 || col == matrixWidth - 1) {
                    float x = startX + col * squareSize;
                    float y = startY + (matrixHeight - row - 1) * squareSize;
                    batch.draw(field[row][col], x, y, squareSize, squareSize);
                }
            }
        }

        for (int row = 0; row < matrixHeight - 1; row++) {
            for (int col = 1; col < matrixWidth - 1; col++) {
                float x = startX + col * squareSize;
                float y = startY + (matrixHeight - row - 1) * squareSize;
                batch.draw(field[row][col], x, y, squareSize, squareSize);
            }
        }
    }

    public void dispose() {
        borderTexture.dispose();
        freeSpaceTexture.dispose();
    }

    public Texture[][] getField() {
        return field;
    }

    public void addFigure(Figure figure) throws InterruptedException {
        int figureSize = figure.getSize();
        Texture[][] figureToSet = figure.getShape();
        int y = figureSize - 1;
        int col, row;

        //TODO: Implement addFigure logic
        if(figureSize == 2) {
            for (row = 0; row < figureSize; row++) {
                for (col = 6; col < 8; col++) {
                    field[row][col] = figureToSet[row][y];
                }
                Thread.sleep(1000);
                for (col = 6; col < 8; col++) {
                    field[row+1][col] = figureToSet[row][y];
                    if (y == 0) break;
                }
                --y;
            }
        } else if (figureSize == 3) {
            try {
                for (row = 0; row < figureSize; row++) {
                    for (col = 5; col < 8; col++) {
                        field[row][col] = figureToSet[row][y];
                    }
                    Thread.sleep(1000);
                    for (col = 5; col < 8; col++) {
                        field[row + 1][col] = figureToSet[row][y];
                        if (y == 0) break;
                    }
                    --y;
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }

        } else {
            try {
                for (row = 0; row < figureSize; row++) {
                    for (col = 5; col < 9; col++) {
                        field[row][col] = figureToSet[row][y];
                    }
                    for (col = 5; col < 9; col++) {
                        Thread.sleep(1000);
                        field[row + 1][col] = figureToSet[row][y];
                        if (y == 0) break;
                    }
                    --y;
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        updateField(figureSize);
    }

    private void updateField(int size) {
        for (int x = 0; x < HEIGHT - 2; x++) {
            for (int y = 1; y < WIDTH  - 1; y++) {
                Texture texture = field[x][y];
                field[x][y] = field[x + 1][y];
                field[x + 1][y] = texture;
            }
        }
        Tetris.camera.update();
    }
}