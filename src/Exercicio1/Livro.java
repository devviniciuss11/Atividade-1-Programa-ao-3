package Exercicio1;

public class Livro {
    private String titulo;
    private Autor autor;
    private boolean disponivel = true;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public void emprestarvr(){
        if(!disponivel) throw new IllegalStateException("Livro Indisponivel");
        disponivel = false;

    }

    public void devolver() {
        disponivel = true;
    }
}
