package Exercicio6;

public class Produto {

    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto: " + nome;
    }

}
