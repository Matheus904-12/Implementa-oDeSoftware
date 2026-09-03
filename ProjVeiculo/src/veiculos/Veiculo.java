package veiculos;

public class Veiculo {
    public String marca;
    public String modelo;
    public int ano;
    public double valor;

    public Veiculo(String marca, String modelo, int ano, double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public double calcularVenda(int tipoFormaPagamento) {
        if (tipoFormaPagamento == 1) {
            return this.valor - (this.valor * 0.10);
        } else if (tipoFormaPagamento == 2) {
            return this.valor + (this.valor * 0.10);
        }
        return this.valor;
    }
}
