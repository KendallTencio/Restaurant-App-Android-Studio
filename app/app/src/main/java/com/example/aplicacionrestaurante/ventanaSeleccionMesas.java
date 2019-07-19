package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ventanaSeleccionMesas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_seleccion_mesas);
    }

    /** Se llama al probar el firebase*/
    public void crearMesaFireBase(View view){
        Intent intent = new Intent(this, pruebaFireBase.class);
        startActivity(intent);
    }
}
