package com.example.aplicacionrestaurante;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dirigirAPedidos(View view){
        Intent intent = new Intent(this, ventanaVisualizacionPedidos.class);
        startActivity(intent);
    }

    public void dirigirAMesas(View view){
        Intent intent = new Intent(this, ventanaSeleccionMesas.class);
        startActivity(intent);
    }

    public void generarPedidoFireBase(View view){
        Intent intent = new Intent(this, realizarPedido.class);
        startActivity(intent);
    }

    public void verConfiguraciones(View view){
        Intent intent = new Intent(this, ventanaConfiguraciones.class);
        startActivity(intent);
    }
 }
