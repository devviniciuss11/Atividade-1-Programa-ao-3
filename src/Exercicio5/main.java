package Exercicio5;

public class main {
    public static void main(String[]args){

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(new ItemCarrinho(new Produto("Teclado", 150), 2));
        carrinho.adicionarItem(new ItemCarrinho(new Produto("Relogio", 50), 9));

        Carrinho carrinho2 = new Carrinho();
        carrinho2.adicionarItem(new ItemCarrinho(new Produto("Mesa", 200), 2));
        carrinho2.adicionarItem(new ItemCarrinho(new Produto("Papel", 30), 12));

        System.out.println("Subtotal: $" + carrinho.subtotalTotal());
        System.out.println("Desconto: $" + carrinho.desconto());
        System.out.println("Frete: $" + carrinho.frete());
        System.out.println("Total: $" + carrinho.total());

        System.out.println("Subtotal: $" + carrinho2.subtotalTotal());
        System.out.println("Desconto: $" + carrinho2.desconto());
        System.out.println("Frete: $" + carrinho2.frete());
        System.out.println("Total: $" + carrinho2.total());



    }
}
