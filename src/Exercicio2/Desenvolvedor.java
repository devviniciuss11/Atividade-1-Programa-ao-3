package Exercicio2;

public class Desenvolvedor extends Funcionario{
    public Desenvolvedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public double calcularSalario() {
        return Salario * 5;
    }
}
