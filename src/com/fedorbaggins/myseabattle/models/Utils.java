package com.fedorbaggins.myseabattle.models;


import java.util.Random;

public class Utils {
    static public void setAreaShip(Ship ship, Cell[][] field) {
        int currentPosX;
        int currentPosY;

        if (ship.getSizeOfShip() == 1) {
            setSingleShipArea(ship, field);
        }
        if (ship.getSizeOfShip() > 1) {
            setMultiShipArea(ship, field);
        }
    }

    private static void setMultiShipArea(Ship ship, Cell[][] field) {
        if (ship.isHorizontalPosition()) {
            for (int i = -1; i <= ship.getSizeOfShip(); i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.getSizeOfShip()) {
                        //
                    } else {
                        try {
                            if (field[ship.getPositionX() + i][ship.getPositionY() + j] == Cell.EMPTY)
                                field[ship.getPositionX() + i][ship.getPositionY() + j] = Cell.AREA;
                        } catch (Exception e) {

                        }
                    }

                }
            }
        }

        if (!ship.isHorizontalPosition()) {
            for (int i = -1; i <= ship.getSizeOfShip(); i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0 && i >= 0 && i < ship.getSizeOfShip()) {

//
                    } else {
                        try {
                            if (field[ship.getPositionX() + j][ship.getPositionY() + i] == Cell.EMPTY)
                                field[ship.getPositionX() + j][ship.getPositionY() + i] = Cell.AREA;
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
                        if (field[ship.getPositionX() + i][ship.getPositionY() + j] == Cell.EMPTY)
                            field[ship.getPositionX() + i][ship.getPositionY() + j] = Cell.AREA;
                    } catch (Exception e) {

                    }
                }

            }

        }
    }

    public static void setShips(Ship ship, Cell[][] field) {
        field[ship.getPositionX()][ship.getPositionY()] = Cell.SHIP;

        if (ship.isHorizontalPosition()) {
            for (int i = 0; i < ship.getSizeOfShip(); i++) {
                if (ship.getSizeOfShip() == 1) field[ship.getPositionX() + i][ship.getPositionY()] = Cell.SHIP;
                if (ship.getSizeOfShip() == 2) field[ship.getPositionX() + i][ship.getPositionY()] = Cell.SHIP;
                if (ship.getSizeOfShip() == 3) field[ship.getPositionX() + i][ship.getPositionY()] = Cell.SHIP;
                if (ship.getSizeOfShip() == 4) field[ship.getPositionX() + i][ship.getPositionY()] = Cell.SHIP;
                if (i == ship.getSizeOfShip()) {
                    ship.setSternX(ship.getPositionX() + i);
                    ship.setSternX(ship.getPositionY());

                }
            }
            Utils.setAreaShip(ship, field);
        } else if (!ship.isHorizontalPosition()) {
            for (int i = 0; i < ship.getSizeOfShip(); i++) {
                if (ship.getSizeOfShip() == 1) field[ship.getPositionX()][ship.getPositionY() + i] = Cell.SHIP;
                if (ship.getSizeOfShip() == 2) field[ship.getPositionX()][ship.getPositionY() + i] = Cell.SHIP;
                if (ship.getSizeOfShip() == 3) field[ship.getPositionX()][ship.getPositionY() + i] = Cell.SHIP;
                if (ship.getSizeOfShip() == 4) field[ship.getPositionX()][ship.getPositionY() + i] = Cell.SHIP;
                if (i == ship.getSizeOfShip()) {
                    ship.setSternY(ship.getPositionY() + i);
                    ship.setSternX(ship.getPositionX());

                }
            }

            Utils.setAreaShip(ship, field);
        }

    }

    static boolean isValidPlace(Field mainField, int sizeOfShip) {
        if (mainField.getField()[mainField.pointX][mainField.pointY] != Cell.EMPTY) return false;
        if (mainField.posHor) {
            if (mainField.pointX + sizeOfShip > Field.SIZE_OF_FIELD) return false;
            for (int i = mainField.pointX; i < mainField.pointX + sizeOfShip; i++) {
                if (mainField.getField()[i][mainField.pointY] != Cell.EMPTY) return false;
            }
        }
        if (!mainField.posHor) {
            if (mainField.pointY + sizeOfShip > Field.SIZE_OF_FIELD) return false;
            for (int i = mainField.pointY; i < mainField.pointY + sizeOfShip; i++) {
                if (mainField.getField()[mainField.pointX][i] != Cell.EMPTY) return false;
            }
        }
        return true;
    }

    static void fillEmptyField(Cell[][] field) {
        for (int i = 0; i < Field.SIZE_OF_FIELD; i++) {
            for (int j = 0; j < Field.SIZE_OF_FIELD; j++) {
                field[i][j] = Cell.EMPTY;
            }
        }
    }

    static void newShip(int sizeOfShip, Field mainField) {
        Ship currentShip = new Ship(sizeOfShip, mainField.pointX, mainField.pointY, mainField.posHor);
        Utils.setShips(currentShip, mainField.getField());
        mainField.getSetOfShips().add(currentShip);
    }

    public static void createShipsAndAllArea(Field mainField) {
        Ship currentShip;
        Random r = new Random();
        for (int i = 1; i <= Field.MAX_SIZE_OF_SHIP + 1; i++) {
            for (int y = i + 1; y <= Field.MAX_SIZE_OF_SHIP + 1; y++) {

                mainField.pointX = r.nextInt(10);
                mainField.pointY = r.nextInt(10);
                mainField.posHor = r.nextBoolean();
                if (Utils.isValidPlace(mainField, i)) {
                    Utils.newShip(i, mainField);

                } else if (!Utils.isValidPlace(mainField, i)) {
                    do {
                        mainField.pointX = r.nextInt(10);
                        mainField.pointY = r.nextInt(10);
                        mainField.posHor = r.nextBoolean();
                    }
                    while (!Utils.isValidPlace(mainField, i));
                    currentShip = new Ship(i, mainField.pointX, mainField.pointY, mainField.posHor);
                    Utils.setShips(currentShip, mainField.getField());
                    mainField.setOfShips.add(currentShip);
                }

            }
        }
    }
}
