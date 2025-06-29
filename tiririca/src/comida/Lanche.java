package comida;

import item.Item;

public class Lanche extends Item {
    private boolean comMolho;

    public Lanche(String nome, String descricao, double precoBase) {
        super(nome, descricao, precoBase);
        this.comMolho = false;
    }

    @Override
    public boolean aceitaPersonalizacao() {
        return true;
    }

    public boolean isComMolho() {
        return comMolho;
    }

    public void setComMolho(boolean comMolho) {
        this.comMolho = comMolho;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\n  Molho: " + (comMolho ? "Sim" : "Não");
    }
}