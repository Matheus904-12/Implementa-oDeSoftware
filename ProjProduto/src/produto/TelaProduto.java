package produto;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaProduto extends JFrame {

    private Produto meuProduto;

    private JTextField txtDescricao;
    private JTextField txtValorCompra;
    private JTextField txtEstoque;
    private JTextField txtValorVenda;
    private JTextField txtQtdVender;

    public TelaProduto() {
        super("Cadastro e Venda de Produto");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel lblDescricao = new JLabel("Descrição:");
        JLabel lblValorCompra = new JLabel("Valor de Compra:");
        JLabel lblEstoque = new JLabel("Estoque:");
        JLabel lblValorVenda = new JLabel("Valor de Venda:");
        JLabel lblQtdVender = new JLabel("Qtd a Vender:");

        txtDescricao = new JTextField(15);
        txtValorCompra = new JTextField(15);
        txtEstoque = new JTextField(15);
        txtValorVenda = new JTextField(15);
        txtValorVenda.setEditable(false);
        txtQtdVender = new JTextField(15);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnExibir = new JButton("Exibir Valor de Venda");
        JButton btnVender = new JButton("Vender");

        btnCadastrar.addActionListener(this::cadastrar);
        btnExibir.addActionListener(this::exibir);
        btnVender.addActionListener(this::vender);

        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescricao)
                                .addComponent(lblValorCompra)
                                .addComponent(lblEstoque)
                                .addComponent(lblValorVenda)
                                .addComponent(lblQtdVender))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtDescricao)
                                .addComponent(txtValorCompra)
                                .addComponent(txtEstoque)
                                .addComponent(txtValorVenda)
                                .addComponent(txtQtdVender)))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addComponent(btnExibir)
                        .addComponent(btnVender)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescricao).addComponent(txtDescricao))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValorCompra).addComponent(txtValorCompra))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEstoque).addComponent(txtEstoque))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValorVenda).addComponent(txtValorVenda))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQtdVender).addComponent(txtQtdVender))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar).addComponent(btnExibir).addComponent(btnVender)));

        setContentPane(painel);
        pack();
    }

    private void cadastrar(ActionEvent evt) {
        try {
            String descricao = txtDescricao.getText();
            double valorCompra = Double.parseDouble(txtValorCompra.getText().replace(",", "."));
            int qtdEstoque = Integer.parseInt(txtEstoque.getText());
            meuProduto = new Produto(descricao, valorCompra, qtdEstoque);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor de Compra e Estoque devem ser numéricos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibir(ActionEvent evt) {
        if (meuProduto == null) {
            JOptionPane.showMessageDialog(this, "Cadastre um produto primeiro.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        txtValorVenda.setText(String.valueOf(meuProduto.valorVenda));
    }

    private void vender(ActionEvent evt) {
        if (meuProduto == null) {
            JOptionPane.showMessageDialog(this, "Cadastre um produto primeiro.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int quantidade = Integer.parseInt(txtQtdVender.getText());
            meuProduto.vender(quantidade);
            JOptionPane.showMessageDialog(this, "Venda realizada! Estoque atual: " + meuProduto.qtdEstoque);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Qtd a Vender deve ser numérica.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaProduto().setVisible(true));
    }
}
