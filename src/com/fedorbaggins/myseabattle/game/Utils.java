package com.fedorbaggins.myseabattle.game;


import com.fedorbaggins.myseabattle.models.Cell;
import com.fedorbaggins.myseabattle.models.Field;
import com.fedorbaggins.myseabattle.models.Ship;

public class Utils {
    static public void setAreaShip(Ship ship, Cell[][] field) {
        int currentPosX;
        int currentPosY;

        if (ship.sizeOfShip == 1) {
            setSingleShipArea(ship, field);
        }
        if (ship.sizeOfShip > 1) {
            setMultiShipArea(ship, field);
        }
    }

    private static void setMultiShipArea(Ship ship, Cell[][] field) {
        if (ship.isHorizontalPosition) {
            for (int i = -1; i <= ship.sizeOfShip; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.sizeOfShip) {
                        //
                    } else {
                        try {
                            if (field[ship.positionX + i][ship.positionY + j] == Cell.EMPTY)
                                field[ship.positionX + i][ship.positionY + j] = Cell.AREA;
                        } catch (Exception e) {

                        }
                    }

                }
            }
        }

        if (!ship.isHorizontalPosition) {
            for (int i = -1; i <= ship.sizeOfShip; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.sizeOfShip) {

//
                    } else {
                        try {
                            if (field[ship.positionX + j][ship.positionY + i] == Cell.EMPTY)
                                field[ship.positionX + j][ship.positionY + i] = Cell.AREA;
                        } catch (Exception e) {

                        }
                    }

                }
            }
        }
    }

    private static void setSingleShipArea(Ship ship, Cell[][] field) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    try {
                        if (field[ship.positionX + i][ship.positionY + j] == Cell.EMPTY)
                            field[ship.positionX + i][ship.positionY + j] = Cell.AREA;
                    } catch (Exception e) {

                    }
                }

            }

        }
    }

    public static void setShips(Ship ship, Cell[][] field) {
        field[ship.positionX][ship.positionY] = Cell.SHIP;

        if (ship.isHorizontalPosition) {
            for (int i = 0; i < ship.sizeOfShip; i++) {
                if (ship.sizeOfShip == 1) field[ship.positionX + i][ship.positionY] = Cell.SHIP;
                if (ship.sizeOfShip == 2) field[ship.positionX + i][ship.positionY] = Cell.SHIP;
                if (ship.sizeOfShip == 3) field[ship.positionX + i][ship.positionY] = Cell.SHIP;
                if (ship.sizeOfShip == 4) field[ship.positionX + i][ship.positionY] = Cell.SHIP;
                if (i == ship.sizeOfShip) {
                    ship.sternX = ship.positionX + i;
                    ship.sternY = ship.positionY;

                }
            }
            Utils.setAreaShip(ship, field);
        } else if (!ship.isHorizontalPosition) {
            for (int i = 0; i < ship.sizeOfShip; i++) {
                if (ship.sizeOfShip == 1) field[ship.positionX][ship.positionY + i] = Cell.SHIP;
                if (ship.sizeOfShip == 2) field[ship.positionX][ship.positionY + i] = Cell.SHIP;
                if (ship.sizeOfShip == 3) field[ship.positionX][ship.positionY + i] = Cell.SHIP;
                if (ship.sizeOfShip == 4) field[ship.positionX][ship.positionY + i] = Cell.SHIP;
                if (i == ship.sizeOfShip) {
                    ship.sternY = ship.positionY + i;
                    ship.sternX = ship.positionX;

                }
            }

            Utils.setAreaShip(ship, field);
        }

    }

    public static boolean isValidPlace(int x, int y, boolean posHor, int sizeOfShip, Cell[][] field) {
        if (field[x][y] != Cell.EMPTY) return false;
        if (posHor) {
            if (x + sizeOfShip > Field.getSizeOfField()) return false;
            for (int i = x; i < x + sizeOfShip; i++) {
                if (field[i][y] != Cell.EMPTY) return false;
            }
        }
        if (!posHor) {
            if (y + sizeOfShip > Field.getSizeOfField()) return false;
            for (int i = y; i < y + sizeOfShip; i++) {
                if (field[x][i] != Cell.EMPTY) return false;
            }
        }
        return true;
    }
}
