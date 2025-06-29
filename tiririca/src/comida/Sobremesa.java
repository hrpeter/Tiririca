package comida;

import item.Item;

public class Sobremesa extends Item {
    private final boolean gelada;

    public Sobremesa(String nome, String descricao, double precoBase, boolean gelada) {
        super(nome, descricao, precoBase);
        this.gelada = gelada;
    }

    public boolean isGelada() {
        return gelada;
    }

    @Override
    public String toString() {
        return super.toString() + (gelada ? "\n  Gelada: Sim" : "\n  Gelada: Não");
    }
}