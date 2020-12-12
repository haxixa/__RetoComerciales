package org.example.retocomerciales;

/*
falta la recepción de datos del intent del que se abre y el envio en intent + algunos apartados visuales como toasts
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


import org.example.retocomerciales.Clases.Comercial;
import org.example.retocomerciales.Clases.Linea;
import org.example.retocomerciales.Clases.Partner;
import org.example.retocomerciales.Clases.Pedido;
import org.example.retocomerciales.Clases.Producto;

import java.util.ArrayList;
import java.util.Calendar;
public class activity_pedido2 extends AppCompatActivity {



    Producto[] listaProductos;
    String[] list;

    Spinner sp;
    Pedido pedido;
    EditText prUnidad, descripcion, prTotal, unidades;
    ImageView imagen;
    Button addToPedido, volver;
    Intent intent, extras;

    Producto prod;//producto elegido en el spinner

    float precioUnidad = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pedido2);

        volver  = findViewById(R.id.btn_volver);
        sp = findViewById(R.id.spinner);
        prUnidad = findViewById(R.id.txt_precioUnidad);
        descripcion = findViewById(R.id.txt_descripcion);
        imagen = findViewById(R.id.imagen);
        prTotal = findViewById(R.id.txt_precioTotal);
        unidades = findViewById(R.id.txt_cantidades);
        addToPedido = findViewById(R.id.btn_addToPedido);


        /*datos cargados sin xml
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
        listaProductos.add(new Producto("FPO+", "Funda PistachoO+", "fundaPistacho", 9.54f));*/
        extras = getIntent();
        listaProductos = (Producto[]) extras.getSerializableExtra("listaProductos");

        list = listaNomProductos(listaProductos);//new String[]{"PistachoB", "PistachoA", "PistachoA+", "PistachoO", "PistachoO+", "PistachoPods", "Cargador Pistacho", "Funda PistachoB", "Funda PistachoA", "Funda PistachoA+", "Funda PistachoO", "Funda PistachoO+"};

        final ArrayAdapter lista = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);

        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR); //mes mal

        System.err.println("_______________________________");
        System.err.println("_______________________________");
        System.err.println("_______________________________");
        System.err.println("_______________________________");
        System.err.println("_______________________________");
        System.err.println("_______________________________");

        //Pedido de pruebas
        pedido = new Pedido(fecha, new Partner("ejemplo", "123", "eweqw", "weq123wa", "622s335568", "joncastas@gmai.clascdo"),
                new Comercial("1", "s", "123 12", "Gipuzkoa"));



        lista.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(lista);

        //listener del spinner
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prod = listaProductos[position];
                precioUnidad = prod.getPr_unidad();

                prUnidad.setText(String.valueOf(precioUnidad) + "€");
                descripcion.setText(prod.getDescripcion());
                cambiarImagen(prod.getImagen());
                calcPrecioTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                prUnidad.setText("0€");
            }
        });

        //listener de cambiar unidades
        unidades.addTextChangedListener(new TextWatcher(){

            //cosas de lambda
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) { calcPrecioTotal(); }
        });

        //listener de boton añadir
        addToPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pedido.addLinea(new Linea(prod, Integer.parseInt(unidades.getText().toString())));
                    System.out.println("CANTIDAD ELEGIDA DPM");
                }catch (Exception e){
                    //En caso de que no se haya elegido una cantidad
                    System.out.println("ELIGE LA CANTIDAD PORFA");
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public void cambiarImagen(String nombreImagen){
        switch (nombreImagen){
            case "movil":
                imagen.setImageResource(R.drawable.movil);
                break;

            case "airpodsPistacho":
                imagen.setImageResource(R.drawable.airpodspistacho);
                break;

            case "cargadorPistacho":
                imagen.setImageResource(R.drawable.cargadorpistacho);
                break;


            case "fundaPistacho":
                imagen.setImageResource(R.drawable.fundapistacho);
                break;

            default:
                imagen.setImageResource(R.drawable.x);
                break;

        }
    }

    public String[] listaNomProductos(Producto[] list){
        String[] nombres = new String[list.length];

        for(int i = 0; i < list.length; i++){
            nombres[i] = list[i].getNombre();
        }
        return nombres;
    }

    //metodo para calcular y escribir el precio total
    public void calcPrecioTotal() {
        try {
            float result = precioUnidad * Float.parseFloat(unidades.getText().toString());
            prTotal.setText(String.valueOf(result) + "€");
        }catch (Exception e){
            prTotal.setText("0.0€");
        }
    }

    //metodo para testear
    public void sysoPedido(View v){
        System.out.println("______________________________________________");
        System.out.println("_______________DATOS DE PEDIDO________________");
        System.out.println("______________________________________________");
        System.out.println("");
        System.out.println(" - fecha: " + pedido.getFecha());
        System.out.println(" - comercial: " + pedido.getComercial().getNombre() + " " + pedido.getComercial().getApellidos() + " | " + pedido.getComercial().getEmail() + " | " + pedido.getComercial().getDelegacion());
        System.out.println(" - partner: " +  pedido.getPartner().getCIF() + " " +  pedido.getPartner().getNombre() + " | " +  pedido.getPartner().getEmail() + " | " +  pedido.getPartner().getPoblacion() + " | " +  pedido.getPartner().getTelefono());
        System.out.println(" - lineas: ");
        for (int i=0; i < pedido.getLineas().size(); i++){
            System.out.println("    * " + pedido.getLinea(i).getProducto().getCod() + " " + pedido.getLinea(i).getProducto().getNombre() + " | "  + pedido.getLinea(i).getCantidad() + " | "  + pedido.getLinea(i).getPr_total());
        }
    }
}