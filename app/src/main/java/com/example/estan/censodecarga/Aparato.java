package com.example.estan.censodecarga;

/**
 * Created by Estan on 19/12/2017.
 */

public class Aparato {
private String nombre;
private int cantidad;
private int total;

    public Aparato(String nombre, int cantidad, int total) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
