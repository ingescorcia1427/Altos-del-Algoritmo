package com.example.leonardescorcia.altosdelalgoritmo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Registrar extends AppCompatActivity {
    private EditText cajaNomenclatura, cajaTamano, cajaPrecio;
    private CheckBox chbBalcon, chbSombra;
    private Spinner opc_nom;
    private String[] opc;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajaNomenclatura = (EditText)findViewById(R.id.txtNomenclatura);
        cajaTamano = (EditText)findViewById(R.id.txtTamano);
        cajaPrecio = (EditText)findViewById(R.id.txtPrecio);
        chbBalcon = (CheckBox)findViewById(R.id.chbBalcon);
        chbSombra = (CheckBox)findViewById(R.id.chbSombra);

        opc_nom = (Spinner)findViewById(R.id.spnPiso);
        opc = getResources().getStringArray(R.array.opc_nomenclatura);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_nomenclatura, opc);
        opc_nom.setAdapter(adapter);
    }

    public boolean validartodo (){
        if (cajaNomenclatura.getText().toString().isEmpty()){
            cajaNomenclatura.setError(this.getResources().getString(R.string.validar_nomenclatura));
            cajaNomenclatura.requestFocus();
            return false;
        }
        if (cajaTamano.getText().toString().isEmpty()){
            cajaTamano.setError(this.getResources().getString(R.string.validar_tamano));
            cajaTamano.requestFocus();
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(this.getResources().getString(R.string.validar_precio));
            cajaPrecio.requestFocus();
            return false;
        }

        if (!chbBalcon.isChecked() && !chbSombra.isChecked()){
            new AlertDialog.Builder(this).setMessage(R.string.validar_caracteristica).show();
        }
        return true;
    }

    public boolean validarNomenclatura (View v) {
        if (cajaNomenclatura.getText().toString().isEmpty()) {
            cajaNomenclatura.setError(this.getResources().getString(R.string.validar_nomenclatura));
            cajaNomenclatura.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        cajaNomenclatura.setText("");
        cajaTamano.setText("");
        cajaPrecio.setText("");
        chbBalcon.setChecked(false);
        chbSombra.setChecked(false);
        cajaNomenclatura.requestFocus();
    }

    public void guardar(View v){
        String nomenclatura, piso, tamano, caracteristica="", precio;
        Apartamento ap;

        if (validartodo()){
            nomenclatura = cajaNomenclatura.getText().toString();
            piso = opc_nom.getSelectedItem().toString().trim();
            tamano = cajaTamano.getText().toString();
            precio = cajaPrecio.getText().toString();

            if(chbBalcon.isChecked()){
                caracteristica = getResources().getString(R.string.balcon) + ", ";
            }

            if(chbSombra.isChecked()){
                caracteristica = caracteristica + getResources().getString(R.string.sombra) + ", ";
            }

            caracteristica = caracteristica.substring(0, caracteristica.length()-2);
            ap = new Apartamento(nomenclatura, piso, tamano, caracteristica, precio);
            ap.guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage(R.string.registro_exitoso).show();
            limpiar(v);
        }
    }

}
