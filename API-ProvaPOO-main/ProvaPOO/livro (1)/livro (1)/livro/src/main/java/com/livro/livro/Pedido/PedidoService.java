package com.livro.livro.Pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoTO> list() {
        List<PedidoTO> pedido = new ArrayList<>();
        pedidoRepository.findAll().forEach(l -> 
            pedido.add(new PedidoTO(l.getId(), l.getNmPedido(),l.getTotalPedido(), l.getStatusPedido())));
        return pedido;
    }

    public PedidoTO find(String id) {
        return pedidoRepository.findById(id)
            .map(l -> new PedidoTO(l.getId(), l.getNmPedido(),l.getTotalPedido(), l.getStatusPedido()))
            .orElse(null);
    }

    public void create(PedidoTO pedido) {
        pedidoRepository.save(new PedidoModel(pedido));
    }

    public void delete(String id) {
        pedidoRepository.deleteById(id);
    }

    public void update(String id, PedidoTO in) {

        pedidoRepository.findById(id).ifPresent(l -> {
            l.setNmPedido(in.nmPedido());
            l.setTotalPedido(in.totalPedido());
            l.setStatusPedido(in.statusPedido());
            pedidoRepository.save(l);
        });
    }
    
    
}
