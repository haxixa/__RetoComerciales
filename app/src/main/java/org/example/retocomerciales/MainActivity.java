package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.SupportMapFragment;

import org.example.retocomerciales.Clases.Partner;
import org.example.retocomerciales.Clases.Producto;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    Button _iniciar;
    Intent intent;
    //ArrayList<Producto> listaProductos;
    Producto[] listaProductos;
    Partner[] listaPartners;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

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

        listaPartners = new Partner[]{
            new Partner("1", "Cebanc", "Berio Pasealekua, 50, 20018 Donostia, Gipuzkoa", "A20045548", "943316900", "contacto@cebanc.com"),
            new Partner("2", "Ibermática", "Mikeletegi Pasealekua, 5, 20009 Donostia, Gipuzkoa", "A20038915", "943413500", "contacto@ibermatica.com"),
            new Partner("3", "Dosystem S.L.", "Sagardotegi Kalea, 1, 20160 Lasarte-Oria, SS", "A20040547", "943369533", "contacto@dosystem.com")
        };

        _iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, activity_menu.class);
                intent.putExtra("listaProductos", listaProductos);
                intent.putExtra("listaPartners", listaPartners);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sedeGipuzkoa = new LatLng(43.30492160526047, -2.016846344086027); //Ubicacion mapa
        mMap.addMarker(new MarkerOptions().position(sedeGipuzkoa).title("Sede de Gipuzkoa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sedeGipuzkoa));

        LatLng partnerSicos = new LatLng(43.32300916986545, -1.9822197474185075);
        mMap.addMarker(new MarkerOptions().position(partnerSicos).title("Sicos (Partner)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(partnerSicos));

        LatLng partnerIbermatica = new LatLng(43.28742043250079, -1.9856190798731963);
        mMap.addMarker(new MarkerOptions().position(partnerIbermatica).title("Ibermatica (Partner)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(partnerIbermatica));
    }
}