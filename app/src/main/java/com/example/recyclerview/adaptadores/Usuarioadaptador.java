package com.example.recyclerview.adaptadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.modelos.Usuario;


import java.util.ArrayList;

public class Usuarioadaptador extends ArrayAdapter <Usuario> {

    public Usuarioadaptador (Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.lyitemuser, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemuser, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).nombres);

        TextView lblEmail = (TextView)item.findViewById(R.id.lblEmail);
        lblEmail.setText(getItem(position).email);

        TextView lblWeb = (TextView)item.findViewById(R.id.lblweb);
        lblWeb.setText(getItem(position).website);

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).urlavatar)
                .into(imageView);

        return(item);
    }
}
