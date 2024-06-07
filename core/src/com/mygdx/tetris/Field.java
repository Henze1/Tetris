package com.mygdx.tetris;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Field {
    public Texture borderTexture;
    public Texture freeSpaceTexture;

    private final Texture[][] field = new Texture[22][14];
    Field() {
        borderTexture = new Texture("data/7263.png");
        freeSpaceTexture = new Texture("data/7262.png");

        for (int row = 0; row < 21; row++) {
            for (int col = 1; col < 13; col++) {
                field[row][col] = freeSpaceTexture;
            }
        }



        for (int row = 0; row < 22; row++) {
            field[row][0] = borderTexture;
            field[row][13] = borderTexture;
            if (row == 21) {
                for (int col = 0; col < 14; col++) {
                    field[21][col] = borderTexture;
                }
            }
        }
    }

    public void draw(Batch batch, Texture[][] field) {
        final int squareSize = 49;
        int matrixHeight = 22;
        int matrixWidth = 14;
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
    }

    public Texture[][] getField() {
        return field;
    }

    public void updateField(Figure figure) {
        int x , y;
        int row, col;

        if(figure.getSize() == 2) {
            for (row = 6, x = 0; row < 8 && x < figure.getSize(); row++, x++) {
                for (col = 0, y = 0; col < 4 && y < figure.getSize(); col++, y++) {
                    if (figure.getShapeNumbers()[x][y] == 1) {
                        field[col][row] = figure.getShape()[x][y];
                    }
                }
            }
        } else {
            for (row = 5, x = 0; row < 9 && x < figure.getSize(); row++, x++) {
                for (col = 0, y = 0; col < 4 && y < figure.getSize(); col++, y++) {
                    if (figure.getShapeNumbers()[x][y] == 1) {
                        field[col][row] = figure.getShape()[x][y];
                    }
                }
            }
        }
    }
}