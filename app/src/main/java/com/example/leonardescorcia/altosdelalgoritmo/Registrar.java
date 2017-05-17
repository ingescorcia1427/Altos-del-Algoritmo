package com.example.leonardescorcia.altosdelalgoritmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registrar extends AppCompatActivity {
    private Spinner opc_nom;
    private String[] opc;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        opc_nom = (Spinner)findViewById(R.id.spn_nomen);
        opc = getResources().getStringArray(R.array.opc_nomenclatura);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_nomenclatura, opc);
        opc_nom.setAdapter(adapter);
    }
}
