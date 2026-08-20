package Exercicio1;

public class main  {
    public static void main(String[] args) {


        Autor autor = new Autor("Machado de Assis",23);
        Autor autor2 = new Autor("gabriel",15);
        Livro livro = new Livro("As Cronicas da Facol", autor);
        Usuario usuario = new Usuario("Vinicius");
        Livro livro1 = new Livro("As Aventuras de Alisson",autor);
        Livro livro2 = new Livro("As Aventuras de Arthur",autor);
        Livro livro3 = new Livro("As Aventuras de Neymar",autor2);
        Usuario usuario1 = new Usuario("Matheus");

        usuario1.emprestar(livro);
        System.out.println("o Livro " + livro.getTitulo() + " Foi emprestado com sucesso para " + usuario1.getNome());
        System.out.println("Livro Disponivel ?: "+livro.isDisponivel());
        livro.devolver();
        System.out.println("Livro Disponivel ?: "+livro.isDisponivel());
        usuario.emprestar(livro1);
        usuario1.emprestar(livro2);
        livro2.devolver();
        Emprestimo emprestimo = new Emprestimo(usuario,livro3);
        emprestimo.devolver();

        System.out.println("quantidade de emprestimos " + usuario.quantidadeEmprestimos());


    }
}
