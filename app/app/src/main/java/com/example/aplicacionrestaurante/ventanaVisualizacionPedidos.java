package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.Dataset;

public class ventanaVisualizacionPedidos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_visualizacion_pedidos);
        recyclerView = (RecyclerView) findViewById(R.id.listaPedidosRV);

        //Aquí debe ir la lectura de la BD en Firebase
           //Se deben agregar el listado de datos en
              //una variable llamada listaPedidos
        String[] listaPedidos = {"Pedido1","Pedido2"};



        // Usar en caso de que los elementos no afecten el tamaño
        //recyclerView.setHasFixedSize(true);

        // Se establece un LLM como el Layout del RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Se establece el adaptador para el RecyclerView
        mAdapter = new MyAdapter(this, listaPedidos);
        recyclerView.setAdapter(mAdapter);

    }
}
