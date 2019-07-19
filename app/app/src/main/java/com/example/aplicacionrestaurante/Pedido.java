package com.example.aplicacionrestaurante;

public class Pedido {
    private String Estado;
    private String Mesa;

    public Pedido() {
    }

    public Pedido(String estado, String mesa, String idKey) {
        Estado = estado;
        Mesa = mesa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String mesa) {
        Mesa = mesa;
    }
}
