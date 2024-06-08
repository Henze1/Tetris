package com.mygdx.tetris.threads;

import com.mygdx.tetris.Field;
import com.mygdx.tetris.Figure;

public class FieldUpdateThread extends Thread {
    private final Field field;
    private final Figure figure;
    public FieldUpdateThread(Field field, Figure figure) {
        this.field = field;
        this.figure = figure;
    }
    @Override
    public void run() {
        while (true) {
            try {
                field.addFigure(figure);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(22000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
