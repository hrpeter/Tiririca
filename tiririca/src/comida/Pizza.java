package comida;

import item.Item;
import java.util.List;

public class Pizza extends Item {
    private int tamanho;
    private boolean bordaRecheada;
    private final List<String> ingredientesBase;

    public Pizza(String nome, String descricao, double precoBase, 
                 int tamanho, boolean bordaRecheada, List<String> ingredientesBase) {
        super(nome, descricao, precoBase);
        this.tamanho = tamanho;
        this.bordaRecheada = bordaRecheada;
        this.ingredientesBase = List.copyOf(ingredientesBase);
    }

    @Override
    public boolean aceitaPersonalizacao() {
        return true;
    }

    public int getTamanho() { return tamanho; }
    public boolean isBordaRecheada() { return bordaRecheada; }
    public List<String> getIngredientesBase() { return ingredientesBase; }

    public void setTamanho(int tamanho) { this.tamanho = tamanho; }
    public void setBordaRecheada(boolean bordaRecheada) { this.bordaRecheada = bordaRecheada; }

    @Override
    public String toString() {
        String tamanhoStr = switch(tamanho) {
            case 1 -> "Pequena";
            case 2 -> "Media";
            case 3 -> "Grande";
            default -> "Indefinido";
        };

        return super.toString() + 
               "\n  Tamanho: " + tamanhoStr +
               "\n  Borda Recheada: " + (bordaRecheada ? "Sim" : "Nao") +
               "\n  Ingredientes Base: " + String.join(", ", ingredientesBase);
    }
}