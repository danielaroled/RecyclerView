package com.example.recyclerview.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    public String nombres;
    public String email;
    public String website;

    public String urlavatar;


    public Usuario(JSONObject a) throws JSONException {
        nombres =  a.getString("first_name").toString() + " " + a.getString("last_name").toString();

        email =  a.getString("email").toString() ;
        website =  a.getString("avatar").toString() ;
        urlavatar = a.getString("avatar").toString() ;
    }


    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Usuario(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
