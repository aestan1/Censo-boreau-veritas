package com.example.estan.censodecarga;

/**
 * Created by Estan on 23/12/2017.
 */

public class Celda {
    private int fila;
    private int columna;
    private String dato;
    private Boolean esNumero;

    public Celda(int fila, int columna, String dato, Boolean esNumero) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        this.esNumero = esNumero;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Boolean getEsNumero() {
        return esNumero;
    }

    public void setEsNumero(Boolean esNumero) {
        this.esNumero = esNumero;
    }
    public void guardar(){
        listaCeldas.guardar(this);
    }
}


