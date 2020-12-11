package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.example.retocomerciales.Clases.Producto;

import java.util.ArrayList;

public class activity_menu extends AppCompatActivity {

    ArrayList<Producto> listaProductos;
    TextView lista; //para probar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        lista = findViewById(R.id.datosProd);

        Intent extras = getIntent();
        listaProductos = (ArrayList<Producto>) extras.getSerializableExtra("listaProductos");


        lista.setText(texto(listaProductos));

    }

    public String texto (ArrayList<Producto> list){
        String text = "";
        for(Producto prod : list){
            text = text + prod.getCod() + "|" + prod.getNombre() + "|" + prod.getDescripcion() + "|" + prod.getPr_unidad() +"\n";
        }
        return  text;
    }
}