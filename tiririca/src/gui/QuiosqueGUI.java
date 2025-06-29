package gui;

import core.*;
import item.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class QuiosqueGUI {
    private JFrame frame;
    private Cardapio cardapio;
    private Cliente cliente;
    private Estabelecimento restaurante;
    private Pedido pedidoAtual;

    private DefaultListModel<Item> modelEditarPedido;

    public QuiosqueGUI() {
        cardapio = new Cardapio();
        cliente = new Cliente("Cliente Exemplo");
        restaurante = new Estabelecimento();
        pedidoAtual = restaurante.gerarPedido(cliente);
        criarInterface();
    }

    private void criarInterface() {
        frame = new JFrame("Quiosque de Autoatendimento");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Cardapio", criarPainelCardapio());
        tabbedPane.add("Personalizar", criarPainelPersonalizacao());
        tabbedPane.add("Resumo", criarPainelResumo());
        tabbedPane.add("Pedidos", criarPainelPedidos());
        tabbedPane.add("Editar Pedido", criarPainelEditarPedido());
        tabbedPane.add("Gerente", criarPainelGerente());

        // Atualizar lista de edição ao trocar para aba "Editar Pedido"
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int idx = tabbedPane.getSelectedIndex();
                String titulo = tabbedPane.getTitleAt(idx);
                if (titulo.equals("Editar Pedido")) {
                    atualizarListaEditarPedido();
                }
            }
        });

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel criarPainelCardapio() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Item item : cardapio.getItens()) {
            JButton btn = new JButton("<html><b>" + item.getNome() + "</b><br>" +
                    item.getDescricao() + "<br><b>R$ " +
                    String.format("%.2f", item.getPrecoBase()) + "</b></html>");
            btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
            btn.setBackground(new Color(230, 240, 255));
            btn.addActionListener(e -> {
                pedidoAtual.adicionarItem(item);
                JOptionPane.showMessageDialog(frame, item.getNome() + " adicionado ao pedido!");
            });
            panel.add(btn);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return new JPanel(new BorderLayout()) {
            {
                add(scrollPane, BorderLayout.CENTER);
            }
        };
    }

    private JPanel criarPainelEditarPedido() {
        JPanel panel = new JPanel(new BorderLayout());

        modelEditarPedido = new DefaultListModel<>();
        JList<Item> listaItens = new JList<>(modelEditarPedido);

        // Renderizador simples (exemplo: nome + preço simples)
        listaItens.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Item item) {
                    setText(item.getNome() + " - R$ " + String.format("%.2f", item.calcularPreco()));
                }
                return this;
            }
        });

        JScrollPane scroll = new JScrollPane(listaItens);

        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(e -> atualizarListaEditarPedido());

        JButton btnRemover = new JButton("Remover Selecionado");
        btnRemover.addActionListener(e -> {
            Item selecionado = listaItens.getSelectedValue();
            if (selecionado != null) {
                pedidoAtual.removerItem(selecionado);
                atualizarListaEditarPedido();
                JOptionPane.showMessageDialog(frame, "Item removido do pedido.");
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione um item para remover.");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAtualizar);
        btnPanel.add(btnRemover);

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        // Inicializa lista no momento da criação do painel
        atualizarListaEditarPedido();

        return panel;
    }

    private void atualizarListaEditarPedido() {
        if (modelEditarPedido != null) {
            modelEditarPedido.clear();
            for (Item item : pedidoAtual.getItens()) {
                modelEditarPedido.addElement(item);
            }
        }
    }

    private JPanel criarPainelGerente() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea pedidosArea = new JTextArea();
        pedidosArea.setEditable(false);

        JButton btnAtualizar = new JButton("Atualizar Pedidos");
        btnAtualizar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Pedido p : restaurante.getPedidos()) {
                sb.append("Pedido #").append(p.getId())
                        .append(" - ").append(p.getCliente().getNome())
                        .append(" - Status: ").append(p.getStatus())
                        .append("\n").append(p.getResumo()).append("\n\n");
            }
            pedidosArea.setText(sb.toString());
        });

        JButton btnAvancarStatus = new JButton("Avançar Status do Último Pedido");
        btnAvancarStatus.addActionListener(e -> {
            if (!restaurante.getPedidos().isEmpty()) {
                Pedido ultimo = restaurante.getPedidos().get(restaurante.getPedidos().size() - 1);
                StatusPedido atual = ultimo.getStatus();
                StatusPedido novo = switch (atual) {
                    case PENDENTE -> StatusPedido.EM_PREPARO;
                    case EM_PREPARO -> StatusPedido.PRONTO;
                    case PRONTO -> StatusPedido.ENTREGUE;
                    case ENTREGUE -> StatusPedido.FINALIZADO;
                    case FINALIZADO -> StatusPedido.FINALIZADO;
                };

                restaurante.atualizarStatus(ultimo.getId(), novo);
                JOptionPane.showMessageDialog(frame,
                        "Status do pedido #" + ultimo.getId() + " atualizado para: " + novo);
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAtualizar);
        btnPanel.add(btnAvancarStatus);

        panel.add(new JScrollPane(pedidosArea), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel criarPainelPersonalizacao() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel ingredientesPanel = new JPanel(new GridLayout(0, 1));
        ingredientesPanel.setBorder(BorderFactory.createTitledBorder("Ingredientes Adicionais"));
        for (Ingrediente i : cardapio.getIngredientesDisponiveis()) {
            JCheckBox check = new JCheckBox(i.toString());
            check.addActionListener(e -> {
                if (check.isSelected()) {
                    if (!pedidoAtual.getItens().isEmpty()) {
                        Item ultimoItem = pedidoAtual.getItens().get(pedidoAtual.getItens().size() - 1);
                        if (ultimoItem.aceitaPersonalizacao()) {
                            ultimoItem.adicionarIngrediente(i);
                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Este item não aceita ingredientes adicionais.");
                            check.setSelected(false);
                        }
                    }
                }
            });
            ingredientesPanel.add(check);
        }

        JPanel personalizacoesPanel = new JPanel(new GridLayout(0, 1));
        personalizacoesPanel.setBorder(BorderFactory.createTitledBorder("Personalizações"));
        for (Personalizacao p : cardapio.getPersonalizacoesDisponiveis()) {
            JCheckBox check = new JCheckBox(p.toString());
            check.addActionListener(e -> {
                if (check.isSelected()) {
                    if (!pedidoAtual.getItens().isEmpty()) {
                        Item ultimoItem = pedidoAtual.getItens().get(pedidoAtual.getItens().size() - 1);
                        if (ultimoItem.aceitaPersonalizacao()) {
                            ultimoItem.adicionarPersonalizacao(p);
                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Este item não aceita personalizações.");
                            check.setSelected(false);
                        }
                    }
                }
            });
            personalizacoesPanel.add(check);
        }

        panel.add(ingredientesPanel, BorderLayout.NORTH);
        panel.add(personalizacoesPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel criarPainelResumo() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea resumoArea = new JTextArea(15, 50);
        resumoArea.setEditable(false);

        JButton btnAtualizar = new JButton("Atualizar Resumo");
        btnAtualizar.addActionListener(e -> resumoArea.setText(pedidoAtual.getResumo()));

        JButton btnFinalizar = new JButton("Finalizar Pedido");
        btnFinalizar.addActionListener(e -> {
            restaurante.atualizarStatus(pedidoAtual.getId(), StatusPedido.FINALIZADO);
            JOptionPane.showMessageDialog(frame, "Pedido #" + pedidoAtual.getId() + " finalizado!");
            pedidoAtual = restaurante.gerarPedido(cliente);
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAtualizar);
        btnPanel.add(btnFinalizar);

        panel.add(new JScrollPane(resumoArea), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel criarPainelPedidos() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea pedidosArea = new JTextArea(15, 50);
        pedidosArea.setEditable(false);

        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Pedido p : cliente.getPedidos()) {
                sb.append(p.getResumo()).append("\n\n");
            }
            pedidosArea.setText(sb.toString());
        });

        panel.add(new JScrollPane(pedidosArea), BorderLayout.CENTER);
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuiosqueGUI::new);
    }
}