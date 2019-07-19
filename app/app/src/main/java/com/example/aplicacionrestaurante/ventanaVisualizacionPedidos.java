package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


public class ventanaVisualizacionPedidos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView textPruebaFireBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_visualizacion_pedidos);

        recyclerView = (RecyclerView) findViewById(R.id.listaPedidosRV);
        new FirebaseDatabaseHelper().leerPedidos(new FirebaseDatabaseHelper.EstadoDato() {
            @Override
            public void DatoCargado(List<Pedido> pedidos, List<String> llaves) {
                new MyAdapter().setConfig(recyclerView, ventanaVisualizacionPedidos.this, pedidos, llaves);
            }

            @Override
            public void DatoInsertado() {

            }

            @Override
            public void DatoActualizado() {

            }

            @Override
            public void DatoBorrado() {

            }
        });

      //  layoutManager = new LinearLayoutManager(this);
      //  recyclerView.setLayoutManager(layoutManager);

      //  mAdapter = new MyAdapter(this, listaPedidos);
      //  recyclerView.setAdapter(mAdapter);
    }
}
