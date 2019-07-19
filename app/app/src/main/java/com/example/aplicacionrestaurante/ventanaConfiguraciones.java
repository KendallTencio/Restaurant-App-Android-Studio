package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class ventanaConfiguraciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_configuraciones);
    }
    public void versionApp(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(ventanaConfiguraciones.this).create();
        alertDialog.setTitle("Versión de aplicación");
        alertDialog.setMessage("1.0");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void acercaDe(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(ventanaConfiguraciones.this).create();
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
