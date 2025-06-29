package item;

public class Personalizacao {
    private final String descricao;
    private final double preco;

    public Personalizacao(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return descricao + " (R$ " + String.format("%.2f", preco) + ")";
    }
}