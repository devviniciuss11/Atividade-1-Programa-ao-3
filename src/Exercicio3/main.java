package Exercicio3;

public class main {
    public static void main(String[] args) {
        Pix pix = new Pix("Vinicius","123457");
        pix.processar(100);

        Boleto boleto = new Boleto("Rio Pequeno","123456");
        boleto.processar(100);

        CartaoCredito cartaoCredito = new CartaoCredito("Rio Grande","123459");
        cartaoCredito.processar(100);

        System.out.println("O comprador no Credito foi : " + cartaoCredito.getNomeDoComprador());
        System.out.println("O nome do Comprador no Pix  foi : " + pix.getNomeDoComprador());

    }
}
