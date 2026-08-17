package Exercicio1;

public class Emprestimo {
    private final Usuario usuario;
    private final Livro livro;
    private boolean ativo = true;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void devolver(){
        if(!ativo) throw new IllegalStateException("Emprestimo Ja Devolvido a Biblioteca");
        ativo = false;
        livro.devolver();
    }
}
