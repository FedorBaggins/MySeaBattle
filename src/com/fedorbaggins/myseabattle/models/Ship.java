package com.fedorbaggins.myseabattle.models;


public class Ship {

    private int sizeOfShip;
    private int positionX;
    private int positionY;
    private int sternX;
    private int sternY;
    private boolean isHorizontalPosition;

    Ship(int sizeOfShip, int X, int Y, boolean isHorizontalPosition) {
        this.sizeOfShip = sizeOfShip;
        this.positionX = X;
        this.positionY = Y;
        this.isHorizontalPosition = isHorizontalPosition;
    }

    public int getSizeOfShip() {
        return sizeOfShip;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public boolean isHorizontalPosition() {
        return isHorizontalPosition;
    }

    public void setSternY(int sternY) {
        this.sternY = sternY;
    }

    public void setSternX(int sternX) {
        this.sternX = sternX;
    }

    public int getSternX() {

        return sternX;
    }

    public int getSternY() {
        return sternY;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "isHor-" + isHorizontalPosition +
                ", size" + sizeOfShip +
                ", X=" + positionX +
                ", Y=" + positionY +
                '}' + "\n";
    }
}
