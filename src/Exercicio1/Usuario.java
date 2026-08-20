package Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome) {
        if(nome.isBlank() || nome == null) throw new IllegalArgumentException("Nome Não Preenchido Corretamente");
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void emprestar(Livro livro){
        long ativos = emprestimos.stream().filter(Emprestimo::isAtivo).count();
        if (ativos >= 3){
            throw new IllegalStateException("O Usuario ja possui 3 emprestimos ativos, Sendo esse o Maximo de emprestimos permitido por usuario");
        }
        livro.emprestarvr();
        emprestimos.add(new Emprestimo(this, livro));
    }

    public long quantidadeEmprestimos() {
        long nEmprestimos = emprestimos.stream().filter(Emprestimo::isAtivo).count();
        return nEmprestimos;
    }


}

