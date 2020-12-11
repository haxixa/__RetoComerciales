package org.example.retocomerciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button _iniciar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _iniciar=findViewById(R.id.btn_iniciar);

        _iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    /*public void lanzarPropuesta (){
        Intent intent = new Intent(MainActivity.this, activity_menu.class);
        intent.putExtra("nombre", nombre.getText().toString());
        startActivityForResult(intent, 123);//si no vas devolver dato:  startActivity(intent);
    }*/
}