package com.example.aplicacionrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import butterknife.Bind;
//import butterknife.ButterKnife;

public class pruebaFireBase extends AppCompatActivity {

    private String FIREBASE_URL = "https://restaurantemobileapp.firebaseio.com/";
    private String FIREBASE_CHILD = "restaurantemobileapp";
    private DatabaseReference mDatabase;// ..
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_fire_base);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        //ButterKnife.bind(this);
        //Firebase.setAndroidContext(this);
        //firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
    }

    //@OnClick(R.id.botonTextoToFirebase)
    public void escribirEnFireBase(View view){
        EditText editText = (EditText)findViewById(R.id.textoToFireBase);
        mDatabase.child("test").push().setValue(editText.getText().toString());
        editText.setText("");
    }

}
