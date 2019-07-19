package com.example.aplicacionrestaurante;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText e1;

    public static final String EXTRA_MESSAGE = "com.example.aplicacionrestaurante.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.ingresoTextoPrueba);
    }

    /** Se llama cuando se hace click al botón verOtraPestaña */
    public void enviarMensajePrueba(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.ingresoTextoPrueba);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Se llama cuando se hace click al botón pedido */
    public void dirigirAPedidos(View view){
        Intent intent = new Intent(this, ventanaVisualizacionPedidos.class);
        startActivity(intent);
    }

    /** Se llama cuando se hace click al botón mesas */
    public void dirigirAMesas(View view){
        Intent intent = new Intent(this, ventanaSeleccionMesas.class);
        startActivity(intent);
    }

    /** Se llama al probar el firebase*/
    public void generarPedidoFireBase(View view){
        Intent intent = new Intent(this, pruebaFireBase.class);
        startActivity(intent);
    }

    public void acercaDe(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Acerca de");
        alertDialog.setMessage("Creadores: \n- Javith Aguero\n- Kendall Tencio");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}
