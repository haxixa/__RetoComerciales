package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.retocomerciales.Clases.Producto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button _iniciar;
    Intent intent;
    ArrayList<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _iniciar=findViewById(R.id.btn_iniciar);

        listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("PPB_", "PistachoB", "movil", 79.95f));
        listaProductos.add(new Producto("PPA_", "PistachoA", "movil", 125.95f));
        listaProductos.add(new Producto("PPA+", "PistachoA+", "movil", 153.45f));
        listaProductos.add(new Producto("PPO_", "PistachoO", "movil", 279.95f));
        listaProductos.add(new Producto("PPO+", "PistachoO+", "movil", 293.45f));
        listaProductos.add(new Producto("PPod", "PistachoPods", "airpodsPistacho", 24.95f));
        listaProductos.add(new Producto("Carg", "Cargador Pistacho", "cargadorPistacho", 12.34f));
        listaProductos.add(new Producto("FPB_", "Funda PistachoB", "fundaPistacho", 7f));
        listaProductos.add(new Producto("FPA_", "Funda PistachoA", "fundaPistacho", 7f));
        listaProductos.add(new Producto("FPA+", "Funda PistachoA+", "fundaPistacho", 8.54f));
        listaProductos.add(new Producto("FPO_", "Funda PistachoO", "fundaPistacho", 8f));
        listaProductos.add(new Producto("FPO+", "Funda PistachoO+", "fundaPistacho", 9.54f));

        _iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarPropuesta();
            }
        });
    }


    public void lanzarPropuesta (){
        Intent intent = new Intent(MainActivity.this, activity_menu.class);
        intent.putExtra("listaProductos", listaProductos);
        startActivityForResult(intent, 123);//si no vas devolver dato:  startActivity(intent);
    }
}