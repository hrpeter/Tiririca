# Tiririca
Sistema de autoatendimento em Java para lancherias e restaurantes, com estrutura orientada a objetos, cardápio dinâmico, múltiplos pedidos por cliente e acompanhamento de status.
# 🍔 Sistema de Quiosque de Autoatendimento

Este projeto simula um sistema de autoatendimento para lancherias e restaurantes, onde o cliente pode visualizar o cardápio, adicionar itens, ver o resumo do pedido e acompanhar o status. O estabelecimento pode gerar pedidos e atualizar seu status conforme o andamento.

---

## 📚 Objetivos

- Aplicar os princípios da Programação Orientada a Objetos (POO) com Java.
- Simular o processo de pedido e atendimento em um quiosque digital.
- Utilizar herança, polimorfismo, interfaces, classes abstratas e coleções (`ArrayList`).

---

## 📦 Estrutura de Pacotes

- `app` → Classe principal com o método `main()` (ponto de entrada).
- `core` → Classes principais do sistema: `Cliente`, `Pedido`, `Estabelecimento`.
- `comida` → Itens do cardápio: `Lanche`, `Bebida`, `Sobremesa`.
- `item` → Classe `Cardapio`, responsável por organizar os itens disponíveis.
- `util` → Enumeração `StatusPedido` com os estados possíveis dos pedidos.

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- Java JDK 11 ou superior instalado
- Editor de código (como IntelliJ, Eclipse ou VSCode)

### ▶️ Etapas para executar

1. Faça o clone ou o download do projeto.
2. Garanta que as pastas e arquivos `.java` estão organizados conforme os pacotes indicados.
3. Compile o projeto a partir do terminal com:

```bash
javac app/App.java
```

---

## 📋 Como Utilizar

Durante a execução, o sistema exibirá o seguinte menu:

```
===== MENU =====
1. Ver cardápio
2. Adicionar item ao pedido
3. Ver resumo do pedido
4. Ver status do pedido
0. Finalizar pedido
```

Você pode realizar um ou mais pedidos na mesma sessão.  
Ao final, todos os pedidos realizados pelo cliente serão listados.

---

## 🧪 Testes Manuais

- Verifique se os itens do cardápio são exibidos corretamente.
- Adicione diferentes itens ao pedido e verifique se o resumo reflete corretamente os valores.
- Teste o status do pedido e verifique se ele muda para `PRONTO` após finalização.
- Faça múltiplos pedidos em sequência e confirme se todos são listados no histórico do cliente.

---

## 🛠 Tecnologias Utilizadas

- Java
- Coleções (`ArrayList`)
- Programação Orientada a Objetos:
  - Herança
  - Polimorfismo
  - Encapsulamento
- Organização por pacotes

---

## 💡 Possíveis Melhorias Futuras

- Interface gráfica com Swing ou JavaFX
- Suporte a pagamentos simulados
- Login de funcionários para alterar pedidos
- Cancelamento e edição de pedidos em andamento
- Integração com banco de dados para persistência

---

## 👨‍💻 Autor

Desenvolvido por **Herik Peter** como parte do projeto final da disciplina de **Programação Orientada a Objetos** – Universidade Feevale.
