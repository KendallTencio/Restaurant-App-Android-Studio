package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class detallesDePedido extends AppCompatActivity {


    private TextView mMesa;
    private TextView mEstado;

    private Button mBotonFinalizar;
    private Button mBotonLimpiar;

    private String llave;
    private String mesa;
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_de_pedido);

        llave = getIntent().getStringExtra("llave");
        mesa = getIntent().getStringExtra("mesa");
        estado = getIntent().getStringExtra("estado");

        mMesa = (TextView) findViewById(R.id.mesaPedidoDetalles);
        mMesa.setText(mesa);
        mEstado = (TextView) findViewById(R.id.estadoPedidoDetalles);
        mEstado.setText(estado);

        mBotonFinalizar = (Button) findViewById(R.id.botonFinalizarPedido);
        mBotonLimpiar = (Button) findViewById(R.id.botonLimpiarPedido);

        mBotonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pedido pedido = new Pedido();
                pedido.setMesa(mMesa.getText().toString());
                pedido.setEstado("Finalizado");

                new FirebaseDatabaseHelper().actualizarPedido(llave, pedido, new FirebaseDatabaseHelper.EstadoDato() {
                    @Override
                    public void DatoCargado(List<Pedido> pedidos, List<String> llaves) {

                    }

                    @Override
                    public void DatoInsertado() {

                    }

                    @Override
                    public void DatoActualizado() {
                        Toast.makeText(detallesDePedido.this, "Se ha finalizado el pedido", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }

                    @Override
                    public void DatoBorrado() {

                    }
                });
            }
        });

        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FirebaseDatabaseHelper().borrarPedido(llave, new FirebaseDatabaseHelper.EstadoDato() {
                    @Override
                    public void DatoCargado(List<Pedido> pedidos, List<String> llaves) {

                    }

                    @Override
                    public void DatoInsertado() {

                    }

                    @Override
                    public void DatoActualizado() {

                    }

                    @Override
                    public void DatoBorrado() {
                        Toast.makeText(detallesDePedido.this, "Se ha limpiado el pedido", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                });
            }
        });
    }
}
