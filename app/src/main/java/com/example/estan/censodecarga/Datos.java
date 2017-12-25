package com.example.estan.censodecarga;

import java.util.ArrayList;

/**
 * Created by Estan on 19/12/2017.
 */

public class Datos {
    private static ArrayList<Aparato> aparatos= new ArrayList<>();

    public static void guardar(Aparato a){
        aparatos.add(a);
    }

    public static ArrayList<Aparato> obtener(){
        return aparatos;
    }

}