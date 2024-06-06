package com.mygdx.tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Field {
    public Texture borderTexture;
    public Texture freeSpaceTexture;

    private final Texture[][] field = new Texture[22][14];
    Field() {
        borderTexture = new Texture("data/7263.png");
        freeSpaceTexture = new Texture("data/7262.png");

        for (int row = 0; row < 22; row++) {
            for (int col = 0; col < 12; col++) {
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

    public void draw(Batch batch) {
        final int squareSize = 49;
        final int matrixWidth = 14;
        final int matrixHeight = 21;
        final int startX = -Gdx.graphics.getWidth() / 2 + 618;
        final int startY = -Gdx.graphics.getHeight() / 2;

        for (int row = 0; row < matrixHeight; row++) {
            for (int col = 0; col < matrixWidth; col++) {
                if (row == matrixHeight - 1 || col == 0 || col == matrixWidth - 1) {
                    float x = startX + col * squareSize;
                    float y = startY + (matrixHeight - row - 1) * squareSize;
                    batch.draw(borderTexture, x, y, squareSize, squareSize);
                }
            }
        }
    }

    public void dispose() {
        borderTexture.dispose();
    }

    public Texture[][] getField() {
        return field;
    }
}