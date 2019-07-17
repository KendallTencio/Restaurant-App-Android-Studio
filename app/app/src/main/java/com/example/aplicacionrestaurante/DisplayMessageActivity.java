package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Obtener el intent que inició esta actividad y extraer el texto
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capturar el textView en la interfaz y mostrar el texto enviado en este
        TextView textView = findViewById(R.id.textoAMostrarPrueba);
        textView.setText(message);
    }
}
