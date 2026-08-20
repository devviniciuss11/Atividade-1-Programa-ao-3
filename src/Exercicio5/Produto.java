package Exercicio5;

public record Produto(String nome, double valor) {
    public Produto{
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("O nome do produto esta vazio ou nulo");
        if (valor < 0) throw new IllegalArgumentException("O valor do produto esta invalido");
    }
}
