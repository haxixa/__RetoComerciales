package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.retocomerciales.Clases.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button _iniciar;
    Intent intent;
    //ArrayList<Producto> listaProductos;
    Producto[] listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _iniciar=findViewById(R.id.btn_iniciar);


        listaProductos = new Producto[]{
                new Producto("PPB_", "PistachoB", "movil", 79.95f),
                new Producto("PPA_", "PistachoA", "movil", 125.95f),
                new Producto("PPA+", "PistachoA+", "movil", 153.45f),
                new Producto("PPO_", "PistachoO", "movil", 279.95f),
                new Producto("PPO+", "PistachoO+", "movil", 293.45f),
                new Producto("PPod", "PistachoPods", "airpodsPistacho", 24.95f),
                new Producto("Carg", "Cargador Pistacho", "cargadorPistacho", 12.34f),
                new Producto("FPB_", "Funda PistachoB", "fundaPistacho", 7f),
                new Producto("FPA_", "Funda PistachoA", "fundaPistacho", 7f),
                new Producto("FPA+", "Funda PistachoA+", "fundaPistacho", 8.54f),
                new Producto("FPO_", "Funda PistachoO", "fundaPistacho", 8f),
                new Producto("FPO+", "Funda PistachoO+", "fundaPistacho", 9.54f)};

        _iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarListaProductos();
            }
        });
    }


    public void lanzarListaProductos(){
        intent = new Intent(MainActivity.this, activity_menu.class);
        intent.putExtra("listaProductos", listaProductos);
        startActivity(intent);
    }
}