package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class realizarPedido extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_pedido);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        String[] arraySpinner = new String[] {"1", "2", "3", "4"};
        Spinner s = (Spinner) findViewById(R.id.spinnerNumeroMesa);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void realizarPedido(View view) {
        Pedido p1 = new Pedido();
        Spinner s = (Spinner) findViewById(R.id.spinnerNumeroMesa);

        p1.setMesa(s.getSelectedItem().toString());
        p1.setEstado("En proceso");
        mDatabase.child("Pedidos").push().setValue(p1);

        Toast.makeText(realizarPedido.this, "Pedido realizado", Toast.LENGTH_LONG).show();
        finish();
        return;
    }
}
