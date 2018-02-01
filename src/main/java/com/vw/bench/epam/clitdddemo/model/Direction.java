package com.vw.bench.epam.clitdddemo.model;

public enum Direction {

    NORTH(-1,0),
    SOUTH(1,0),
    WEST(0,-1),
    EAST(0,1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
