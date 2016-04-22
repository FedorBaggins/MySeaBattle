package com.fedorbaggins.myseabattle.models;


public enum Cell {

    SHIP("K"), EMPTY("-"), AREA("|");

    private String cell;

    Cell(String cell) {
        this.cell = cell;
    }

    public String getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return cell;
    }
}
