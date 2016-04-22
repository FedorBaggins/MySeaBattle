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
        setStern(this);
    }

    private void setStern(Ship ship) {
        if (isHorizontalPosition) {
            ship.sternX = ship.positionX + ship.sizeOfShip;
            ship.sternY = ship.positionY;
        } else {
            ship.sternY = ship.positionY + ship.sizeOfShip;
            ship.sternX = ship.positionX;
        }
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
