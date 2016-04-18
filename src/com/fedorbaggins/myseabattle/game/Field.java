package com.fedorbaggins.myseabattle.game;


import java.util.Random;

public class Field {

    private int[][] field;

    static int countOfShips = 10;
    static int maxSizeOfShip = 4;
    final static int SIZE_OF_FIELD = 10;
    int pointX;
    int pointY;
    boolean posHor;

    Random r;

    Field() {
        r = new Random();
        field = new int[SIZE_OF_FIELD][SIZE_OF_FIELD];
        for (int i = 1; i <= maxSizeOfShip + 1; i++) {
            for (int y = i + 1; y <= maxSizeOfShip + 1; y++) {

                pointX = r.nextInt(10);
                pointY = r.nextInt(10);
                posHor = r.nextBoolean();
                if (Utils.isValidPlace(pointX, pointY, posHor, i, field) == true) {
                    Utils.setShips(new Ship(i, pointX, pointY, posHor), field);

                } else if (Utils.isValidPlace(pointX, pointY, posHor, i, field) == false) {
                    do {
                        pointX = r.nextInt(10);
                        pointY = r.nextInt(10);
                        posHor = r.nextBoolean();
                    }
                    while (Utils.isValidPlace(pointX, pointY, posHor, i, field) == false);
                    Utils.setShips(new Ship(i, pointX, pointY, posHor), field);
                }

            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 9) System.out.printf("%3d", field[j][i]);
                else System.out.printf("%3d%n", field[j][i]);
            }
        }
    }
}
