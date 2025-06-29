package item;

import core.Pedido;

public interface GerenciadorPedidos {
    void adicionarPedido(Pedido pedido);
    void removerPedido(Pedido pedido);
    Pedido buscarPedidoPorId(int id);
}