package com.mygdx.tetris.threads;

import com.mygdx.tetris.Figure;

public class FigureGenThread extends Thread {
    private final Figure figure;


    public FigureGenThread(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        while (true) {
            figure.setFigure();
            try {
                Thread.sleep(21000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
