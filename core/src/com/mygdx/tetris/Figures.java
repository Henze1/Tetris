package com.mygdx.tetris;

public class Figures {
    private static final int I_Shape = 0;
    private static final int J_Shape = 1;
    private static final int L_Shape = 2;
    private static final int S_Shape = 4;
    private static final int Z_Shape = 6;
    private static final int O_Shape = 3;
    private static final int T_Shape = 5;

    private int[][] shape;

    public Figures(int value) {
        if (value < 0 || value > 6) {
            System.out.println("Invalid Shape");
            throw new IllegalArgumentException();
        }

        switch (value) {
            case I_Shape:
                this.shape = setIShape();
                break;
            case J_Shape:
                this.shape = setJShape();
                break;
            case L_Shape:
                this.shape = setLShape();
                break;
            case O_Shape:
                this.shape = setOShape();
                break;
            case S_Shape:
                this.shape = setSShape();
                break;
            case T_Shape:
                this.shape = setTShape();
                break;
            case Z_Shape:
                this.shape = setZShape();
                break;
        }
    }

    private int[][] setIShape() {
        this.shape = new int[][] {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        return this.shape;
    }

    private int[][] setJShape() {
        this.shape = new int[][] {
            {0, 1, 0},
            {0, 1, 0},
            {1, 1, 0}
        };
        return this.shape;
    }

    private int[][] setLShape() {
        this.shape = new int[][] {
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 0}
        };
        return this.shape;
    }

    private int[][] setOShape() {
        this.shape = new int[][] {
            {1, 1},
            {1, 1}
        };
        return this.shape;
    }

    private int[][] setSShape() {
        this.shape = new int[][] {
            {0, 1, 1},
            {1, 1, 0},
            {0, 0, 0}
        };
        return this.shape;
    }

    private int[][] setZShape() {
        this.shape = new int[][] {
            {1, 1, 0},
            {0, 1, 1},
            {0, 0, 0}
        };
        return this.shape;
    }

    private int[][] setTShape() {
        this.shape = new int[][] {
            {0, 1, 0},
            {1, 1, 1},
            {0, 0, 0}
        };
        return this.shape;
    }

    public int[][] getShape() {
        return shape;
    }
}
