package com.mygdx.tetris;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Figure {
    private static final int I_Shape = 0;
    private static final int J_Shape = 1;
    private static final int L_Shape = 2;
    private static final int O_Shape = 3;
    private static final int S_Shape = 4;
    private static final int T_Shape = 5;
    private static final int Z_Shape = 6;

    private int[][] shapeNumbers;
    private Texture[][] shape;
    private final List<Texture> blocks;
    private final Random random;

    private int size;

    public Figure() {
        blocks = new ArrayList<>();
        blocks.add(new Texture("data/7251.png"));//red,0
        blocks.add(new Texture("data/7252.png"));//blue,1
        blocks.add(new Texture("data/7253.png"));//green,2
        blocks.add(new Texture("data/7254.png"));//yellow,3
        blocks.add(new Texture("data/7255.png"));//orange,4
        blocks.add(new Texture("data/7257.png"));//pink,4
        blocks.add(new Texture("data/7259.png"));//light blue,6
        blocks.add(new Texture("data/7262.png"));//brown for free spaces,7
        random = new Random();
    }

    public synchronized void setFigure() {
        int value = random.nextInt(7);

        switch (value) {
            case I_Shape:
                setIShape(random.nextInt(7));
                break;
            case J_Shape:
                setJShape(random.nextInt(7));
                break;
            case L_Shape:
                setLShape(random.nextInt(7));
                break;
            case O_Shape:
                setOShape(random.nextInt(7));
                break;
            case S_Shape:
                setSShape(random.nextInt(7));
                break;
            case T_Shape:
                setTShape(random.nextInt(7));
                break;
            case Z_Shape:
                setZShape(random.nextInt(7));
                break;
        }
    }

    private synchronized void setIShape(int num) {
        this.shapeNumbers = new int[][] {
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(num), blocks.get(7), blocks.get(7), blocks.get(7)},
                {blocks.get(num), blocks.get(7), blocks.get(7), blocks.get(7)},
                {blocks.get(num), blocks.get(7), blocks.get(7), blocks.get(7)},
                {blocks.get(num), blocks.get(7), blocks.get(7), blocks.get(7)}
        };
        size = 4;
    }

    private synchronized void setJShape(int num) {
        this.shapeNumbers = new int[][] {
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(7), blocks.get(num), blocks.get(7)},
                {blocks.get(7), blocks.get(num), blocks.get(7)},
                {blocks.get(num), blocks.get(num), blocks.get(7)}
        };
        size = 3;
    }

    private synchronized void setLShape(int num) {
        this.shapeNumbers = new int[][] {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(num), blocks.get(7), blocks.get(7)},
                {blocks.get(num), blocks.get(7), blocks.get(7)},
                {blocks.get(num), blocks.get(num), blocks.get(7)}
        };
        size = 3;
    }

    private synchronized void setOShape(int num) {
        this.shapeNumbers = new int[][] {
                {1, 1},
                {1, 1}
        };

        this.shape = new Texture[][] {
                {blocks.get(num), blocks.get(num)},
                {blocks.get(num), blocks.get(num)}
        };
        size = 2;
    }

    private synchronized void setSShape(int num) {
        this.shapeNumbers = new int[][] {
                {0, 1, 1},
                {1, 1, 0},
                {0, 0, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(7), blocks.get(num), blocks.get(num)},
                {blocks.get(num), blocks.get(num), blocks.get(7)},
                {blocks.get(7), blocks.get(7), blocks.get(7)}
        };
        size = 3;
    }

    private synchronized void setZShape(int num) {
        this.shapeNumbers = new int[][] {
                {1, 1, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(num), blocks.get(num), blocks.get(7)},
                {blocks.get(7), blocks.get(num), blocks.get(num)},
                {blocks.get(7), blocks.get(7), blocks.get(7)}
        };
        size = 3;
    }

    private synchronized void setTShape(int num) {
        this.shapeNumbers = new int[][] {
                {0, 1, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        this.shape = new Texture[][] {
                {blocks.get(7), blocks.get(num), blocks.get(7)},
                {blocks.get(num), blocks.get(num), blocks.get(num)},
                {blocks.get(7), blocks.get(7), blocks.get(7)}
        };
        size = 3;
    }

    public synchronized Texture[][] getShape() {
        return shape;
    }

    public synchronized int getSize() {
        return size;
    }

    public synchronized int[][] getShapeNumbers() {
        return shapeNumbers;
    }
}
