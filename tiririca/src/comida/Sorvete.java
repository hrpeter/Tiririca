package comida;

import item.Item;

public class Sorvete extends Item {
    private String sabor;
    private int quantidadeBolas;

    public Sorvete(String nome, String descricao, double precoBase, String sabor, int quantidadeBolas) {
        super(nome, descricao, precoBase);
        this.sabor = sabor;
        this.quantidadeBolas = quantidadeBolas;
    }

    public String getSabor() {
        return sabor;
    }

    public int getQuantidadeBolas() {
        return quantidadeBolas;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setQuantidadeBolas(int quantidadeBolas) {
        this.quantidadeBolas = quantidadeBolas;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\n  Sabor: " + sabor +
               "\n  Quantidade de Bolas: " + quantidadeBolas;
    }
}