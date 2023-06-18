package com.livro.livro.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")

public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private String id;

    @Column(name = "nmPedido")
    private String nmPedido;

    @Column(name = "totalPedido")
    private float totalPedido;

    @Column(name = "statusPedido")
    private String statusPedido;

    public String getId() {
        return id;
    }

    public String getNmPedido() {
        return nmPedido;
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNmPedido(String nmPedido) {
        this.nmPedido = nmPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public PedidoModel() {

    }

    public PedidoModel(PedidoTO to) {
        this.id = to.id();
        this.nmPedido = to.nmPedido();
        this.totalPedido = to.totalPedido();
        this.statusPedido = to.statusPedido();
    }

}