package Exercicio2;

public class Estagiario extends Funcionario{
    public Estagiario(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public double calcularSalario() {
        return Salario * 10;
    }
}
