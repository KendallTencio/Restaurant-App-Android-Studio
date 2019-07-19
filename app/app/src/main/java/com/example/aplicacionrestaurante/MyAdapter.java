package com.example.aplicacionrestaurante;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter {
    private Context mContext;
    private adaptadorRecyclerPedidos mAdaptadorPedido;
    public void setConfig(RecyclerView recyclerView, Context context, List<Pedido> pedidos, List<String> llaves){
        mContext = context;
        mAdaptadorPedido = new adaptadorRecyclerPedidos(pedidos, llaves);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAdaptadorPedido);
    }

    public class adaptadorRecyclerPedidos extends RecyclerView.Adapter<Item> {
        private List<Pedido> mListaPedidos;
        private  List<String> mLlaves;

        public adaptadorRecyclerPedidos(List<Pedido> mListaPedidos, List<String> mLlaves) {
            this.mListaPedidos = mListaPedidos;
            this.mLlaves = mLlaves;
        }

        @Override
        public Item onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Item(parent);
        }

        @Override
        public void onBindViewHolder(Item holder, int position) {
            holder.bind(mListaPedidos.get(position), mLlaves.get(position));
        }

        @Override
        public int getItemCount() {
            return mListaPedidos.size();
        }


    }

    public class Item extends RecyclerView.ViewHolder {
        private TextView mesa;
        private TextView estado;

        private String llave;

        public Item(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.costume_row_listapedidos, parent, false));

            mesa = (TextView) itemView.findViewById(R.id.itemPedido_Mesa);
            estado = (TextView) itemView.findViewById(R.id.itemPedido_Estado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, detallesDePedido.class);
                    intent.putExtra("llave",llave);
                    intent.putExtra("estado",estado.getText().toString());
                    intent.putExtra("mesa",mesa.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(Pedido pedido, String llave){
            mesa.setText(pedido.getMesa());
            estado.setText(pedido.getEstado());
            this.llave = llave;
        }
    }
}