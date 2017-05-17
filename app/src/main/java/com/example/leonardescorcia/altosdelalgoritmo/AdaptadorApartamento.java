package com.example.leonardescorcia.altosdelalgoritmo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Leonard Escorcia on 17/05/2017.
 */

public class AdaptadorApartamento extends BaseAdapter {
    private Context contexto;
    private ArrayList<Apartamento> apartamento;

    public AdaptadorApartamento(Context contexto, ArrayList<Apartamento> apartamento) {
        this.contexto = contexto;
        this.apartamento = apartamento;
    }

    @Override
    public int getCount() {
        return apartamento.size();
    }

    @Override
    public Object getItem(int position) {
        return apartamento.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(apartamento.get(position).getNomenclatura());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
