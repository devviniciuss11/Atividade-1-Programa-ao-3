package Exercicio3;

public class CartaoCredito extends Pagamento {
    public CartaoCredito(String nomeDoComprador, String cpfDoComprador) {
        super(nomeDoComprador, cpfDoComprador);

    }
    public double ValorTaxa() {
        return 2.13;
    }

    @Override
    public void processar(double valor) {
        System.out.printf("Cartao De Credito: R$ %.2f%n", valor + ValorTaxa());
    }
}
