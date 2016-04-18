package com.fedorbaggins.myseabattle.game;


public class Utils {
    static public void setAreaShip(Ship ship, int[][] field) {
        int currentPosX;
        int currentPosY;

        if (ship.sizeOfShip == 1) {
            setSingleShip(ship, field);
        }
        if (ship.sizeOfShip > 1) {
            setMultiShip(ship, field);
        }
    }

    private static void setMultiShip(Ship ship, int[][] field) {
        if (ship.isHorizontalPosition == true) {
            for (int i = -1; i <= ship.sizeOfShip; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.sizeOfShip) {
                        //
                    } else {
                        try {
                            if (field[ship.positionX + i][ship.positionY + j] == 0)
                                field[ship.positionX + i][ship.positionY + j] = -ship.sizeOfShip;
                        } catch (Exception e) {

                        }
                    }

                }
            }
        }

        if (ship.isHorizontalPosition == false) {
            for (int i = -1; i <= ship.sizeOfShip; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.sizeOfShip) {

//
                    } else {
                        try {
                            if (field[ship.positionX + j][ship.positionY + i] == 0)
                                field[ship.positionX + j][ship.positionY + i] = -ship.sizeOfShip;
                        } catch (Exception e) {

                        }
                    }

                }
            }
        }
    }

    private static void setSingleShip(Ship ship, int[][] field) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    try {
                        if (field[ship.positionX + i][ship.positionY + j] == 0)
                            field[ship.positionX + i][ship.positionY + j] = -1;
                    } catch (Exception e) {

                    }
                }

            }

        }
    }

    protected static void setShips(Ship ship, int[][] field) {
        field[ship.positionX][ship.positionY] = 1;

        if (ship.isHorizontalPosition == true) {
            for (int i = 0; i < ship.sizeOfShip; i++) {
                if (ship.sizeOfShip == 1) field[ship.positionX + i][ship.positionY] = 21;
                if (ship.sizeOfShip == 2) field[ship.positionX + i][ship.positionY] = 22;
                if (ship.sizeOfShip == 3) field[ship.positionX + i][ship.positionY] = 23;
                if (ship.sizeOfShip == 4) field[ship.positionX + i][ship.positionY] = 24;
                if (i == ship.sizeOfShip) {
                    ship.sternX = ship.positionX + i;
                    ship.sternY = ship.positionY;

                }
            }
            Utils.setAreaShip(ship, field);
        } else if (ship.isHorizontalPosition == false) {
            for (int i = 0; i < ship.sizeOfShip; i++) {
                if (ship.sizeOfShip == 1) field[ship.positionX][ship.positionY + i] = 11;
                if (ship.sizeOfShip == 2) field[ship.positionX][ship.positionY + i] = 12;
                if (ship.sizeOfShip == 3) field[ship.positionX][ship.positionY + i] = 13;
                if (ship.sizeOfShip == 4) field[ship.positionX][ship.positionY + i] = 14;
                if (i == ship.sizeOfShip) {
                    ship.sternY = ship.positionY + i;
                    ship.sternX = ship.positionX;

                }
            }

            Utils.setAreaShip(ship, field);
        }

    }

    protected static boolean isValidPlace(int x, int y, boolean posHor, int sizeOfShip, int[][] field) {
        if (field[x][y] != 0) return false;
        if (posHor == true) {
            if (x + sizeOfShip > Field.SIZE_OF_FIELD) return false;
            for (int i = x; i < x + sizeOfShip; i++) {
                if (field[i][y] != 0) return false;
            }
        }
        if (posHor == false) {
            if (y + sizeOfShip > Field.SIZE_OF_FIELD) return false;
            for (int i = y; i < y + sizeOfShip; i++) {
                if (field[x][i] != 0) return false;
            }
        }
        return true;
    }
}
