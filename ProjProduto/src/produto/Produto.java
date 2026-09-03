package produto;

public class Produto {
    public String descricao;
    public double valorCompra;
    public double valorVenda;
    public int qtdEstoque;

    public Produto(String descricao, double valorCompra, int qtdEstoque) {
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.qtdEstoque = qtdEstoque;
        this.valorVenda = valorCompra + (valorCompra * 0.50);
    }

    public void vender(int quantidade) {
        if (quantidade <= this.qtdEstoque) {
            this.qtdEstoque -= quantidade;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
        }
    }
}
