package com.example.leonardescorcia.altosdelalgoritmo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Leonard Escorcia on 17/05/2017.
 */

public class Apartamento {
    String nomenclatura, piso, tamano, caracteristica, precio;

    public Apartamento(String nomenclatura, String piso, String tamano, String caracteristica, String precio) {
        this.nomenclatura = nomenclatura;
        this.piso = piso;
        this.tamano = tamano;
        this.caracteristica = caracteristica;
        this.precio = precio;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getPiso() {
        return piso;
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

    public void setPiso(String piso) {
        this.piso = piso;
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


    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        //Abrir la conexión de la base de datos en modo escritura
        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto, "DBApartamentos", null, 3);
        db = aux.getWritableDatabase();

        //Insertar forma 1
        sql = "INSERT INTO Apartamentos values('"
                +this.getNomenclatura()+"','"
                +this.getPiso()+"','"
                +this.getTamano()+"','"
                +this.getCaracteristica()+"','"
                +this.getPrecio()+"')";

        db.execSQL(sql);

        //Cerrar conexión
        db.close();
    }

    public void modificar(Context contexto){
        //declarar las variables
        String sql;
        SQLiteDatabase db;

        //Abrir ña conexión de base de datos en modo escritura
        ApartamentosSQLiteOpenHelper aux=new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,3);
        db=aux.getWritableDatabase();

        sql="UPDATE Apartamentos SET piso ='"+this.getPiso()
                +"',metros='"+this.getTamano()
                +"',precio='"+this.getPrecio()
                +"',balcon='"+this.getCaracteristica()
                +"'where nomenclatura='"+this.getNomenclatura()+"'";
        db.execSQL(sql);

        db.close();
    }

}
