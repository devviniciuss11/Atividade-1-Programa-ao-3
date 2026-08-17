package Exercicio1;

public class Autor {
    private String nome;
    private int idade;

    public Autor(String nome, int idade) {
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome Não Preenchido Corretamente");
        this.nome = nome;
        if(idade <= 0) throw new IllegalArgumentException("Idade Não Preenchida Corretamente");
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
