package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity ;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.example.recyclerview.WebServices.Asynchtask;
import com.example.recyclerview.WebServices.WebService;
import com.example.recyclerview.adaptadores.Usuarioadaptador;
import com.example.recyclerview.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    public ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstusers);


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList lstUsuarios;
        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

        lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        Usuarioadaptador adapatorUsuario = new Usuarioadaptador(this, lstUsuarios);

        lstOpciones.setAdapter(adapatorUsuario);


    }
}