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
        System.out.println("In the thread FieldUpdate");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                field.updateField(figure);
                System.out.println(FieldUpdateThread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
