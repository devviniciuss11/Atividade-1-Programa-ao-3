package Exercicio8;


import java.util.*;
public class Funcionario implements Comparable<Funcionario> {
    private String nome;
    private double salario;
    private String setor;

    public Funcionario(String nome, double salario, String setor) {
        this.nome = nome;
        this.salario = salario;
        this.setor = setor;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public double getSalario() {return salario;}

    public void setSalario(double salario) {this.salario = salario;}

    public String getSetor() {return setor;}

    public void setSetor(String setor) {this.setor = setor;}

    @Override
    public String toString(){
        return "nome: " + nome + " == Salario: " + salario + " == Setor: " + setor;
    }

    @Override
    public int compareTo(Funcionario outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }
}
