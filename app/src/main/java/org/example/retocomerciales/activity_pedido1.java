package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.retocomerciales.Clases.Producto;

public class activity_pedido1 extends AppCompatActivity {

    Button siguiente, volver;
    Intent intent, extras;
    Producto[] listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pedido1);

        siguiente = findViewById(R.id.btn_siguiente);
        volver = findViewById(R.id.btn_volver);

        extras = getIntent();
        listaProductos = (Producto[]) extras.getSerializableExtra("listaProductos");


        //lambdas con listeners para los botones
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity_pedido1.this, activity_pedido2.class);
                intent.putExtra("listaProductos", listaProductos);
                startActivity(intent);
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}