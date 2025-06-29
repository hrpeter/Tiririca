package core;

import item.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {

    private static final AtomicInteger contadorIds = new AtomicInteger(1);

    private final int id;
    private final Cliente cliente;
    private final List<Item> itens;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = contadorIds.getAndIncrement();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(id)
          .append(" - Cliente: ").append(cliente.getNome())
          .append(" - Status: ").append(status).append("\n");
        for (Item item : itens) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}