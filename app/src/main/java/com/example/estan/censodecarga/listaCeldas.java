package com.example.estan.censodecarga;

import java.util.ArrayList;

/**
 * Created by Estan on 23/12/2017.
 */

public class listaCeldas {
    private static ArrayList<Celda> celdas= new ArrayList<>();

    public static void guardar(Celda c){
        celdas.add(c);
    }

    public static ArrayList<Celda> obtener(){
        return celdas;
    }

}