package com.livro.livro.Pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PedidoResource {

    @Autowired
    public PedidoService pedidoService;

    @GetMapping("/menu/pedido")
    public List<PedidoTO> getPedidos(@RequestParam(name = "nmPedido", defaultValue = "") String nmPedido) {
        return (nmPedido.length() > 0)
            ? pedidoService.list().stream().filter(pedido -> pedido.nmPedido().toLowerCase().contains(nmPedido.toLowerCase())).toList()
            : pedidoService.list();
    }

    @GetMapping("/menu/pedido/{id}")
    public PedidoTO getNmPedido(@PathVariable("id") String id) {
        return pedidoService.find(id);
    }

    @PostMapping("/menu/pedido")
    public void postNmPedido(@RequestBody PedidoTO in) {
        pedidoService.create(in);
    }

    @DeleteMapping("/menu/pedido/{id}")
    public void deleteNmPedido(@PathVariable("id") String id) {
        pedidoService.delete(id);
    }
    
    @PutMapping("/menu/pedido/{id}")
    public void putNmPedido(@PathVariable("id") String id, @RequestBody PedidoTO in) {
        pedidoService.update(id, in);
    }
}