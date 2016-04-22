package com.fedorbaggins.myseabattle.models;


public class Ship {
    public int sizeOfShip;
    public int positionX;
    public int positionY;
    public int sternX;
    public int sternY;
    public boolean isHorizontalPosition;
    private Cell cell;

    Ship(int sizeOfShip, int X, int Y, boolean isHorizontalPosition) {
        this.sizeOfShip = sizeOfShip;
        this.positionX = X;
        this.positionY = Y;
        this.isHorizontalPosition = isHorizontalPosition;
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "isHorizontalPosition=" + isHorizontalPosition +
                ", sizeOfShip=" + sizeOfShip +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
