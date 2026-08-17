package Exercicio3;

public class Pix extends Pagamento{
    public Pix(String nomeDoComprador, String cpfDoComprador) {
        super(nomeDoComprador, cpfDoComprador);
    }
    protected double calcularValorTaxa(){
        return 0.6;
    }

    @Override
    public void processar(double valor) {
        System.out.printf("Pix: R$ %.2f%n", valor + calcularValorTaxa());
    }
}
