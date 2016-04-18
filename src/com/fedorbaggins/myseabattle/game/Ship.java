package com.fedorbaggins.myseabattle.game;


public class Ship {
    int sizeOfShip;
    int positionX;
    int positionY;
    int sternX;
    int sternY;
    boolean isHorizontalPosition;

    @Override
    public String toString() {
        return "Ship{" +
                "isHorizontalPosition=" + isHorizontalPosition +
                ", sizeOfShip=" + sizeOfShip +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    Ship(int sizeOfShip, int X, int Y, boolean isHorizontalPosition){
        this.sizeOfShip = sizeOfShip;
        this.positionX = X;
        this.positionY = Y;
        this.isHorizontalPosition = isHorizontalPosition;
    }
}
