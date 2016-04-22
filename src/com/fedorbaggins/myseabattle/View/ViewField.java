package com.fedorbaggins.myseabattle.View;


import com.fedorbaggins.myseabattle.models.Cell;
import com.fedorbaggins.myseabattle.models.Field;

public class ViewField {
    public static void viewField(Cell[][] field){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 9) System.out.printf("%3s", field[j][i]);
                else System.out.printf("%3s%n", field[j][i]);
            }
        }
    }

}
