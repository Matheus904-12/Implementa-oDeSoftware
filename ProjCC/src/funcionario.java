
import javax.swing.JOptionPane;

public class funcionario {
    
    public String nome;
    public String cargo;
    public String setor;
    public double SalarioReal ;
    public double salario;
    
    public double CalcINSS(){
        return SalarioReal = salario * 0.05; 
    }
    
    public double calcIR() {
        if (salario > 10000.00) {
            return salario * 0.275; // 27,5%
        } else if (salario >= 5000.00) {
            return salario * 0.12;  // 12%
        } else {
            return 0.0;                  // 0%
        }
    }
    
  public double calcDescFaltas(int Faltas) {
        return (salario / 30.0 / 8.0) * Faltas;
    }
  
  public double SalarioReal(int Faltas) {
        return salario - CalcINSS() - calcIR() - calcDescFaltas(Faltas);
    }
}
    