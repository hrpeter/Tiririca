package item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Serializable {
    private final String nome;
    private final String descricao;
    private final double precoBase;
    private final List<Ingrediente> ingredientesAdicionais;
    private final List<Personalizacao> personalizacoes;

    public Item(String nome, String descricao, double precoBase) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.ingredientesAdicionais = new ArrayList<>();
        this.personalizacoes = new ArrayList<>();
    }

    // Aqui faz com que nao aceite personalização
    public boolean aceitaPersonalizacao() {
        return false;
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientesAdicionais.add(ingrediente);
    }

    public void adicionarPersonalizacao(Personalizacao personalizacao) {
        personalizacoes.add(personalizacao);
    }

    public double calcularPreco() {
        double precoTotal = precoBase;
        for (Ingrediente i : ingredientesAdicionais) {
            precoTotal += i.getPreco();
        }
        for (Personalizacao p : personalizacoes) {
            precoTotal += p.getPreco();
        }
        return precoTotal;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPrecoBase() { return precoBase; }
    public List<Ingrediente> getIngredientesAdicionais() { return new ArrayList<>(ingredientesAdicionais); }
    public List<Personalizacao> getPersonalizacoes() { return new ArrayList<>(personalizacoes); }

    public String toStringSimples() {
        return nome + " - R$ " + String.format("%.2f", calcularPreco());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(" - R$").append(String.format("%.2f", calcularPreco()));
        if (!ingredientesAdicionais.isEmpty()) {
            sb.append("\n  Ingredientes Adicionais:");
            for (Ingrediente i : ingredientesAdicionais) {
                sb.append("\n    - ").append(i);
            }
        }
        if (!personalizacoes.isEmpty()) {
            sb.append("\n  Personalizacoes:");
            for (Personalizacao p : personalizacoes) {
                sb.append("\n    - ").append(p);
            }
        }
        return sb.toString();
    }
}