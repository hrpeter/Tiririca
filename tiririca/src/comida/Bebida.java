package comida;

import item.Item;

public class Bebida extends Item {
    private final double volume;
    private final boolean comAcucar;

    public Bebida(String nome, String descricao, double precoBase, double volume, boolean comAcucar) {
        super(nome, descricao, precoBase);
        this.volume = volume;
        this.comAcucar = comAcucar;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isComAcucar() {
        return comAcucar;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\n  Volume: " + volume + "ml" +
               "\n  Açúcar: " + (comAcucar ? "Sim" : "Não");
    }
}