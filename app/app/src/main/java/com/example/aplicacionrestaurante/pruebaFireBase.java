package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class pruebaFireBase extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_fire_base);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void escribirEnFireBase(View view) {
        Pedido p1 = new Pedido();
        EditText editText = (EditText) findViewById(R.id.textoToFireBase);
        p1.nombrePedido = editText.getText().toString();
        p1.mesa = "1";
        mDatabase.child("Pedidos").push().setValue(p1);
        editText.setText("");
    }
}


