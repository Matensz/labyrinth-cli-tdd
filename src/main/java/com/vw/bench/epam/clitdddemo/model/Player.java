package com.vw.bench.epam.clitdddemo.model;

import java.util.Objects;

public class Player {
    private CurrentPosition position;
    private String name;

    public Player() {
        this.position = new CurrentPosition();
    }

    public Player(String name, int x, int y) {
        this.name = name;
        this.position = new CurrentPosition(x, y);
    }

    public String getName() {
        return name;
    }

    public CurrentPosition getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public class CurrentPosition {
        private int x;
        private int y;

        public CurrentPosition() {
        }

        CurrentPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CurrentPosition that = (CurrentPosition) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}
