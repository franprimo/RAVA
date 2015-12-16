package com.example.franprimo.rava;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.franprimo.rava.R.color.Rojo;

/**
 * Created by FranPrimo on 7/11/15.
 */
public class MenuAdapter extends ArrayAdapter<String>{

    private Context context;
    private ArrayList<String> datos;
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0, datos);
        this.context = context;
        this.datos = datos;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        TextView texto;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_lista, parent, false);
            texto = (TextView) convertView.findViewById(R.id.textView2);

            texto.setText(datos.get(position));

            if(datos.get(position) == "Rojo") {
                texto.setBackgroundColor(Color.argb(255, 255, 0, 0));
                texto.setTextColor(Color.argb(255, 255, 0, 0));
            }
            if(datos.get(position) == "Amarillo") {
                texto.setBackgroundColor(Color.argb(255, 255, 255, 0));
                texto.setTextColor(Color.argb(255, 255, 255, 0));
            }
            if(datos.get(position) == "Verde") {
                texto.setBackgroundColor(Color.argb(255, 0, 255, 0));
                texto.setTextColor(Color.argb(255, 0, 255, 0));
            }
            if(datos.get(position) == "Azul") {
                texto.setBackgroundColor(Color.argb(255, 0, 0, 255));
                texto.setTextColor(Color.argb(255, 0, 0, 255));
            }
        }
        return convertView;
    }
}
