package com.example.aplicacionrestaurante;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePedidos;
    private List<Pedido> pedidos = new ArrayList<>();

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferencePedidos = mDatabase.getReference("Pedidos");
    }

    public interface EstadoDato{
        void DatoCargado(List<Pedido> pedidos, List<String> llaves);
        void DatoInsertado();
        void DatoActualizado();
        void DatoBorrado();
    }

    public void leerPedidos(final EstadoDato estadoDato){
        mReferencePedidos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pedidos.clear();
                List<String> llaves = new ArrayList<>();
                for (DataSnapshot nodoLlave : dataSnapshot.getChildren()){
                    llaves.add(nodoLlave.getKey());
                    Pedido pedido = nodoLlave.getValue(Pedido.class);
                    pedidos.add(pedido);
                }
                estadoDato.DatoCargado(pedidos, llaves);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void actualizarPedido(String llave, Pedido pedido, final EstadoDato estadoDato){
        mReferencePedidos.child(llave).setValue(pedido).
                addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                estadoDato.DatoActualizado();
            }
        });
    }

    public void borrarPedido(String llave, final EstadoDato estadoDato){
        mReferencePedidos.child(llave).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        estadoDato.DatoBorrado();
                    }
                });
    }
}
