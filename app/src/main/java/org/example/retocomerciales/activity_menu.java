package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.example.retocomerciales.Clases.Partner;
import org.example.retocomerciales.Clases.Producto;

public class activity_menu extends AppCompatActivity {

    ImageButton img_calendario, img_pedidos, img_delegaciones, img_partners;
    Button volver;
    Intent intent, extras;
    //listas
    Producto[] listaProductos;
    Partner[] listaPartners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        //findViewById
        img_calendario = findViewById(R.id.img_calendario);
        img_pedidos = findViewById(R.id.img_gestionPedidos);
        img_delegaciones = findViewById(R.id.img_envioDelegacion);
        img_partners = findViewById(R.id.img_gestionPartners);
        volver = findViewById(R.id.btn_volver);

        extras = getIntent();
        listaProductos = (Producto[]) extras.getSerializableExtra("listaProductos");
        listaPartners = (Partner[]) extras.getSerializableExtra("listaPartners");


        //Lambdas con listeners para cada ImageButton
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity_menu.this, activity_calendario.class);
                startActivity(intent);
            }
        });

        img_pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity_menu.this, activity_pedido1.class);
                intent.putExtra("listaProductos", listaProductos);
                intent.putExtra("listaPartners", listaPartners);
                startActivity(intent);
            }
        });

        img_delegaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity_menu.this, activity_envios.class);
                startActivity(intent);
            }
        });

        img_partners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity_menu.this, activity_gestionPartner.class);
                startActivity(intent);
            }
        });

    }

    /*public String texto (Producto[] list){//testeo
        String text = "";
        for(Producto prod : list){
            text = text + prod.getCod() + "|" + prod.getNombre() + "|" + prod.getDescripcion() + "|" + prod.getPr_unidad() +"\n";
        }
        return  text;
    }*/
}