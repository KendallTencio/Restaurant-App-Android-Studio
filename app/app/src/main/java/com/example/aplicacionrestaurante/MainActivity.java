package com.example.aplicacionrestaurante;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    private static Socket s;
    private static PrintWriter printWriter;
    String mensajeSocket = "";
    private static String ip = "192.168.100.4";



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

    public void enviarTextoSocket(View view){
        mensajeSocket = e1.getText().toString();

        tareaSocket ts = new tareaSocket();
        ts.execute();

        Toast.makeText(getApplicationContext(), "Información enviada",Toast.LENGTH_LONG).show();

    }

    class tareaSocket extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params){
            try{
                s = new Socket(ip, 5000);                        // Conecta el socket al puerto 5000
                printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(mensajeSocket);                     //Envía el mensaje  a través del socket
                printWriter.flush();
                printWriter.close();
                s.close();

            }catch(IOException e){
                e.printStackTrace();
            }

            return null;
        }
    }

}
