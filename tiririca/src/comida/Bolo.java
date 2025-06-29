package comida;

import item.Item;

public class Bolo extends Item {
    private String sabor;
    private int pedaços;

    public Bolo(String nome, String descricao, double precoBase, String sabor, int pedaços) {
        super(nome, descricao, precoBase);
        this.sabor = sabor;
        this.pedaços = pedaços;
    }

    public String getSabor() {
        return sabor;
    }

    public int getPedaços() {
        return pedaços;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setPedaços(int pedaços) {
        this.pedaços = pedaços;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\n  Sabor: " + sabor +
               "\n  Pedaços: " + pedaços;
    }
}