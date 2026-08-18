package Exercicio10;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    public int estoque;
    protected String categoria;

    public Produto() {
    }

    public Produto(int id, String nome, double preco, int estoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    private Produto(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String imprimirNome() {
        return this.nome;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public double calcularDesconto(double valor) {
        return preco - (preco * valor / 100);
    }

    private void atualizarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public static String tipoProduto() {
        return "Produto";
    }
}
