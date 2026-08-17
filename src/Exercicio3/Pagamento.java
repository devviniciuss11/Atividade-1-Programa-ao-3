package Exercicio3;

public abstract class Pagamento implements ProcesadoraDePagamentos {
    private String NomeDoComprador;
    private String cpfDoComprador;

    public Pagamento(String nomeDoComprador, String cpfDoComprador) {
        NomeDoComprador = nomeDoComprador;
        this.cpfDoComprador = cpfDoComprador;

    }

    public String getNomeDoComprador() {
        return NomeDoComprador;
    }

    public void setNomeDoComprador(String nomeDoComprador) {
        NomeDoComprador = nomeDoComprador;
    }

    public String getCpfDoComprador() {
        return cpfDoComprador;
    }

    public void setCpfDoComprador(String cpfDoComprador) {
        this.cpfDoComprador = cpfDoComprador;
    }


    protected abstract double calcularValorTaxa();
}
