package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estabelecimento {

    private final List<Pedido> pedidos;

    public Estabelecimento() {
        pedidos = new ArrayList<>();
    }

    /**
     * Aqui ele gera um novo pedido para o cliente, adiciona na lista de pedidos do estabelecimento e também na do cliente.
     * @param cliente cliente que fará o pedido
     * @return o novo pedido criado
     */
    public Pedido gerarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
        cliente.adicionarPedido(pedido);
        return pedido;
    }

    /**
     * Atualiza o status do pedido pelo id dele.
     * @param idPedido id do pedido a atualizar
     * @param novoStatus novo status a ser definido
     * @return true se pedido encontrado e atualizado, false caso contrário
     */
    public boolean atualizarStatus(int idPedido, StatusPedido novoStatus) {
        Optional<Pedido> pedidoOpt = buscarPedidoPorId(idPedido);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.setStatus(novoStatus);
            System.out.println("Pedido #" + idPedido + " atualizado para status: " + novoStatus);
            return true;
        }
        System.out.println("Pedido #" + idPedido + " nao encontrado.");
        return false;
    }

    /**
     * Busca pedido pelo id.
     * @param id id do pedido
     * @return Optional contendo o pedido se encontrado, ou vazio
     */
    public Optional<Pedido> buscarPedidoPorId(int id) {
        return pedidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    /**
     * Busca todos pedidos de um cliente
     * @param cliente cliente para buscar os pedidos
     * @return lista de pedidos do cliente
     */
    public List<Pedido> buscarPedidosPorCliente(Cliente cliente) {
        List<Pedido> lista = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getCliente().equals(cliente)) {
                lista.add(p);
            }
        }
        return lista;
    }

    /**
     * Remove um pedido da lista.
     * @param idPedido id do pedido a remover
     * @return true se removido, false se não encontrado
     */
    public boolean removerPedido(int idPedido) {
        Optional<Pedido> pedidoOpt = buscarPedidoPorId(idPedido);
        if (pedidoOpt.isPresent()) {
            pedidos.remove(pedidoOpt.get());
            System.out.println("Pedido #" + idPedido + " removido.");
            return true;
        }
        System.out.println("Pedido #" + idPedido + " nao encontrado para remover.");
        return false;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Retorna todos os pedidos do estabelecimento.
     * @return lista de todos pedidos
     */
    public List<Pedido> getTodosPedidos() {
        return new ArrayList<>(pedidos);
    }
}