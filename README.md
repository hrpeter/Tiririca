# 🍔 Quiosque de Autoatendimento - Projeto Java

Este projeto implementa um sistema de quiosque para autoatendimento em restaurantes e lanchonetes. O sistema permite visualizar o cardápio, adicionar itens ao pedido, personalizar produtos, acompanhar pedidos, editar itens e gerenciar pedidos pela visão do gerente.

---

## 👨🏼‍💻 Tecnologias e Estrutura

- Linguagem: Java (versão 8+ recomendada)
- GUI: Swing
- Estrutura orientada a objetos com pacotes separados (`core`, `item`, `comida`, `gui`, `util`)
- Serialização para salvar/carregar cardápio (classe `Repositorio`)

---

## Como executar

### Pré-requisitos

- Java JDK instalado (versão 8 ou superior)
- IDE recomendada: IntelliJ IDEA, Eclipse, NetBeans ou similar
- Configuração do projeto para usar o JDK correto

### Passos para execução

1. Clone ou baixe o projeto para sua máquina.

2. Abra o projeto em sua IDE favorita.

3. Compile todos os pacotes.

4. Execute a classe principal `app.App`, que chama a interface gráfica:

```bash
java -cp bin app.App
```

ou execute diretamente a classe app.App na IDE.

5. A interface gráfica do quiosque será aberta.

---

## 💻 Uso da aplicação
- Aba Cardápio: clique nos botões para adicionar itens ao pedido atual.
- Aba Personalizar: selecione ingredientes e personalizações para o último item adicionado que aceitar customização.
- Aba Resumo: visualize o resumo do pedido atual; finalize o pedido para criar um novo.
- Aba Pedidos: veja todos os pedidos feitos pelo cliente.
- Aba Editar Pedido: visualize e remova itens do pedido atual.
- Aba Gerente: visualize todos os pedidos do estabelecimento e atualize o status do último pedido.

---

## 📝 Testes manuais sugeridos
- Adicione diferentes tipos de itens ao pedido e verifique se aparecem no resumo.
- Teste adicionar ingredientes e personalizações apenas em itens que aceitam (ex: lanches, pizzas).
- Tente remover itens pelo painel "Editar Pedido" e observe o efeito.
- Finalize um pedido e confirme que um novo pedido é iniciado.
- Na aba "Pedidos", confira se os pedidos do cliente aparecem corretamente.
- Na aba "Gerente", atualize status dos pedidos e verifique a sequência (PENDENTE → EM_PREPARO → PRONTO → ENTREGUE → FINALIZADO).
- Tente adicionar ingredientes em um item que não aceita e confira a mensagem de erro.
- Teste a atualização da lista de pedidos e do resumo via botão.

---

## 📦 Estrutura de Pacotes
- `app`: classe principal App
- `gui`: interface gráfica do quiosque (QuiosqueGUI)
- `core`: classes centrais do negócio (Cliente, Pedido, Estabelecimento, Cardapio, StatusPedido)
- `item`: classes relacionadas a itens, ingredientes e personalizações (Item, Ingrediente, Personalizacao, interface GerenciadorPedidos)
- `comida`: subclasses de Item para tipos específicos (Pizza, Bebida, Lanche, Bolo, Sorvete, Sobremesa)
- `util`: utilitários para salvar e carregar dados (Repositorio)

---

## Considerações finais
Este projeto é uma base funcional para um sistema de autoatendimento com interface simples. Pode ser expandido com persistência mais robusta, integração com banco de dados, interface mais robusta e completa (responsiva e/ou adaptada para telas touch), integração com sistema de pagamentos entre outras melhorias.

---

## 👨‍💻 Autores

Desenvolvido por **Herik Rafael Peter da Silva e Lucas Matielli Lorenzon** como parte do projeto final da disciplina de **Programação 1** – Universidade Feevale.
