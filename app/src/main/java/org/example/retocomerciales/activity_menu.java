package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.retocomerciales.Clases.Producto;

import java.util.ArrayList;

public class activity_menu extends AppCompatActivity {

    ImageButton 
    Producto[] listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        Intent extras = getIntent();
        listaProductos = (Producto[]) extras.getSerializableExtra("listaProductos");


    }

    /*public String texto (Producto[] list){//testeo
        String text = "";
        for(Producto prod : list){
            text = text + prod.getCod() + "|" + prod.getNombre() + "|" + prod.getDescripcion() + "|" + prod.getPr_unidad() +"\n";
        }
        return  text;
    }*/
}