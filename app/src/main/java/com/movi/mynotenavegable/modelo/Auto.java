package com.movi.mynotenavegable.modelo;

public class Auto {

    private String patente;
    private String marca;
    private String modelo;
    private double precio;

    public Auto(String patente, String marca, String modelo, double precio) {
        this.marca = marca;
        this.precio = precio;
        this.patente = patente;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
