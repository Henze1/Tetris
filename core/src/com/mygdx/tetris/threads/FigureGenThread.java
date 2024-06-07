package com.mygdx.tetris.threads;

import com.mygdx.tetris.Figure;

public class FigureGenThread extends Thread {
    private final Figure figure;


    public FigureGenThread(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        System.out.println("In the thread FigureGen");
        while (true) {
            figure.setFigure();
            System.out.println(FieldUpdateThread.currentThread().getName());
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
