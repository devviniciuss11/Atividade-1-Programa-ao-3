package Exercicio5;

public class main {
    public static void main(String[]args){

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(new ItemCarrinho(new Produto("Teclado", 150), 2));

        System.out.printf("Subtotal: %.2f%nDesconto: %.2f%nFrete: %.2f%nTotal: %.2f%n",
                carrinho.subtotalTotal(), carrinho.desconto(), carrinho.frete(), carrinho.total());


    }
}
