package com.mygdx.tetris;

public class Threading extends Thread {
    Figure figure;

    public Threading(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        while (true) {
            figure.setFigure();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
