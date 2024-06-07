package com.mygdx.tetris.threads;

import com.mygdx.tetris.Figure;

public class FigureGenThread extends Thread {
    private final Figure figure;


    public FigureGenThread(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        System.out.println("In the thread");
        while (true) {
            figure.setFigure();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
