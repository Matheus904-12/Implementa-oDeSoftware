package veiculos;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaVeiculo extends JFrame {

    private Veiculo carro;

    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAno;
    private JTextField txtValor;
    private JTextField txtValorFinal;
    private JComboBox<String> cbFormaPagamento;

    public TelaVeiculo() {
        super("Agência de Veículos");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel lblMarca = new JLabel("Marca:");
        JLabel lblModelo = new JLabel("Modelo:");
        JLabel lblAno = new JLabel("Ano:");
        JLabel lblValor = new JLabel("Valor:");
        JLabel lblFormaPagamento = new JLabel("Forma de Pagamento:");
        JLabel lblValorFinal = new JLabel("Valor Final:");

        txtMarca = new JTextField(15);
        txtModelo = new JTextField(15);
        txtAno = new JTextField(15);
        txtValor = new JTextField(15);
        txtValorFinal = new JTextField(15);
        txtValorFinal.setEditable(false);

        cbFormaPagamento = new JComboBox<>(new String[]{"1 - À Vista", "2 - Cartão"});

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVender = new JButton("Vender");

        btnCadastrar.addActionListener(this::cadastrar);
        btnVender.addActionListener(this::vender);

        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblMarca)
                                .addComponent(lblModelo)
                                .addComponent(lblAno)
                                .addComponent(lblValor)
                                .addComponent(lblFormaPagamento)
                                .addComponent(lblValorFinal))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtMarca)
                                .addComponent(txtModelo)
                                .addComponent(txtAno)
                                .addComponent(txtValor)
                                .addComponent(cbFormaPagamento)
                                .addComponent(txtValorFinal)))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addComponent(btnVender)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMarca).addComponent(txtMarca))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModelo).addComponent(txtModelo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAno).addComponent(txtAno))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValor).addComponent(txtValor))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFormaPagamento).addComponent(cbFormaPagamento))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValorFinal).addComponent(txtValorFinal))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar).addComponent(btnVender)));

        setContentPane(painel);
        pack();
    }

    private void cadastrar(ActionEvent evt) {
        try {
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int ano = Integer.parseInt(txtAno.getText());
            double valor = Double.parseDouble(txtValor.getText().replace(",", "."));
            carro = new Veiculo(marca, modelo, ano, valor);
            JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor devem ser numéricos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void vender(ActionEvent evt) {
        if (carro == null) {
            JOptionPane.showMessageDialog(this, "Cadastre um veículo primeiro.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tipoFormaPagamento = cbFormaPagamento.getSelectedIndex() + 1;
        double valorFinal = carro.calcularVenda(tipoFormaPagamento);
        txtValorFinal.setText(String.valueOf(valorFinal));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaVeiculo().setVisible(true));
    }
}
