package Exercicio3;

public class Boleto extends Pagamento {
    public Boleto(String nomeDoComprador, String cpfDoComprador) {
        super(nomeDoComprador, cpfDoComprador);
    }
    public double calcularValorTaxa() {
        return 1.6;
    }

    @Override
    public void processar(double valor) {
        System.out.printf("Boleto: R$ %.2f%n", valor + calcularValorTaxa());
    }
}
