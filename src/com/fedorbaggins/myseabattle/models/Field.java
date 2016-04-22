package com.fedorbaggins.myseabattle.models;


import com.fedorbaggins.myseabattle.View.ViewField;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private Cell[][] field;

    static int countOfShips = 10;
    public final static int MAX_SIZE_OF_SHIP = 4;
    public final static int SIZE_OF_FIELD = 10;
    int pointX;
    int pointY;
    boolean posHor;

    List<Ship> setOfShips;

    public Field() {

        setOfShips = new ArrayList<>();
        field = new Cell[SIZE_OF_FIELD][SIZE_OF_FIELD];
        Utils.fillEmptyField(field);
        Utils.createShipsAndAllArea(this);
        ViewField.viewField(field);
        ViewField.view(setOfShips);
    }

    public List<Ship> getSetOfShips() {
        return setOfShips;
    }

    public Cell[][] getField() {
        return field;
    }

}

