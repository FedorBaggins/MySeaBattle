package com.fedorbaggins.myseabattle.models;


import com.fedorbaggins.myseabattle.View.ViewField;
import com.fedorbaggins.myseabattle.game.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {

    private Cell[][] field;

    static int countOfShips = 10;
    static int maxSizeOfShip = 4;
    private final static int SIZE_OF_FIELD = 10;
    int pointX;
    int pointY;
    boolean posHor;

    List<Ship> setShips;
    Ship currentShip;

    Random r;

    public Field() {
        r = new Random();
        setShips = new ArrayList<Ship>();
        field = new Cell[SIZE_OF_FIELD][SIZE_OF_FIELD];
        fillEmptyfield(field);
        for (int i = 1; i <= maxSizeOfShip + 1; i++) {
            for (int y = i + 1; y <= maxSizeOfShip + 1; y++) {

                pointX = r.nextInt(10);
                pointY = r.nextInt(10);
                posHor = r.nextBoolean();
                if (Utils.isValidPlace(pointX, pointY, posHor, i, field)) {
                    newShip(i, pointX, pointY, posHor);

                } else if (!Utils.isValidPlace(pointX, pointY, posHor, i, field)) {
                    do {
                        pointX = r.nextInt(10);
                        pointY = r.nextInt(10);
                        posHor = r.nextBoolean();
                    }
                    while (!Utils.isValidPlace(pointX, pointY, posHor, i, field));
                    currentShip = new Ship(i, pointX, pointY, posHor);
                    Utils.setShips(currentShip, field);
                    setShips.add(currentShip);
                }

            }
        }
        ViewField.viewField(field);
    }

    private void fillEmptyfield(Cell[][] field) {
        for (int i = 0; i < this.getSizeOfField(); i++) {
            for (int j = 0; j < this.getSizeOfField(); j++) {
                field[i][j] = Cell.EMPTY;
            }
        }
    }

    public static int getSizeOfField() {
        return SIZE_OF_FIELD;
    }

    void newShip(int i, int pointX, int pointY, boolean posHor) {
        currentShip = new Ship(i, pointX, pointY, posHor);
        Utils.setShips(currentShip, field);
        setShips.add(currentShip);
    }
}

