package com.example.leonardescorcia.altosdelalgoritmo;

/**
 * Created by Leonard Escorcia on 17/05/2017.
 */

public class Apartamento {
    String nomenclatura, tamano, caracteristica, precio;

    public Apartamento(String nomenclatura, String tamano, String caracteristica, String precio) {
        this.nomenclatura = nomenclatura;
        this.tamano = tamano;
        this.caracteristica = caracteristica;
        this.precio = precio;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getTamano() {
        return tamano;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public String getPrecio() {
        return precio;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
