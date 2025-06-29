package core;

import comida.Bebida;
import comida.Bolo;
import comida.Lanche;
import comida.Pizza;
import comida.Sobremesa;
import comida.Sorvete;
import item.Ingrediente;
import item.Item;
import item.Personalizacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cardapio {

    private final List<Item> itens;
    private final List<Ingrediente> ingredientesDisponiveis;
    private final List<Personalizacao> personalizacoesDisponiveis;

    public Cardapio() {
        itens = new ArrayList<>();
        ingredientesDisponiveis = new ArrayList<>();
        personalizacoesDisponiveis = new ArrayList<>();
        carregarItensPadrao();
        carregarIngredientesPadrao();
        carregarPersonalizacoesPadrao();
    }

    private void carregarItensPadrao() {
        // Aqui as pizzas
        itens.add(new Pizza("Pizza Margherita", "Molho de tomate, mussarela e manjericão", 25.0, 2, false, List.of("Molho de tomate", "Mussarela", "Manjericão")));
        itens.add(new Pizza("Pizza Calabresa", "Molho de tomate, calabresa fatiada e cebola", 30.0, 3, true, List.of("Molho de tomate", "Calabresa", "Cebola")));

        // Lanches
        itens.add(new Lanche("X-Salada", "Hambúrguer, alface, tomate, queijo e maionese", 15.0));
        itens.add(new Lanche("X-Bacon", "Hambúrguer, bacon, queijo e molho especial", 18.0));

        // Bebidas
        itens.add(new Bebida("Refrigerante 350ml", "Refrigerante gelado em lata", 5.0, 350, true));
        itens.add(new Bebida("Suco Natural 300ml", "Suco natural de frutas da estação", 7.5, 300, false));

        // Sobremesas
        itens.add(new Sobremesa("Pudim", "Pudim de leite condensado", 8.0, false));
        itens.add(new Sobremesa("Mousse de Maracujá", "Mousse gelado de maracujá", 10.0, true));

        // Bolos
        itens.add(new Bolo("Bolo de Chocolate", "Bolo de chocolate com cobertura", 20.0, "Chocolate", 8));
        itens.add(new Bolo("Bolo de Cenoura", "Bolo de cenoura com cobertura de chocolate", 18.0, "Cenoura", 8));

        // Sorvetes
        itens.add(new Sorvete("Sorvete Casquinha", "Casquinha de sorvete sabor baunilha", 6.0, "Baunilha", 2));
        itens.add(new Sorvete("Sorvete Pote", "Pote de sorvete sabor chocolate", 12.0, "Chocolate", 4));
    }

    private void carregarIngredientesPadrao() {
        ingredientesDisponiveis.add(new Ingrediente("Alface", 0.50));
        ingredientesDisponiveis.add(new Ingrediente("Tomate", 0.70));
        ingredientesDisponiveis.add(new Ingrediente("Bacon", 1.50));
        ingredientesDisponiveis.add(new Ingrediente("Queijo", 1.00));
        ingredientesDisponiveis.add(new Ingrediente("Ovo", 1.20));
        ingredientesDisponiveis.add(new Ingrediente("Cebola", 0.60));
        ingredientesDisponiveis.add(new Ingrediente("Picles", 0.80));
    }

    private void carregarPersonalizacoesPadrao() {
        personalizacoesDisponiveis.add(new Personalizacao("Pão Integral", 0.80));
        personalizacoesDisponiveis.add(new Personalizacao("Pão Francês", 0.50));
        personalizacoesDisponiveis.add(new Personalizacao("Sem Glúten", 1.00));
        personalizacoesDisponiveis.add(new Personalizacao("Molho Especial", 0.90));
        personalizacoesDisponiveis.add(new Personalizacao("Extra Queijo", 1.50));
        personalizacoesDisponiveis.add(new Personalizacao("Sem Lactose", 1.20));
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientesDisponiveis.add(ingrediente);
    }

    public void adicionarPersonalizacao(Personalizacao personalizacao) {
        personalizacoesDisponiveis.add(personalizacao);
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public List<Ingrediente> getIngredientesDisponiveis() {
        return Collections.unmodifiableList(ingredientesDisponiveis);
    }

    public List<Personalizacao> getPersonalizacoesDisponiveis() {
        return Collections.unmodifiableList(personalizacoesDisponiveis);
    }
}