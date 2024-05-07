package org.example.domain;

import java.io.Serializable;

public class Licor implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre,presentacion;
    private double valor;

    public Licor(int id, String nombre, String presentacion, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
