package Exercicio5;

public record ItemCarrinho(Produto produto,int quantidade) {
    public ItemCarrinho{
        if(quantidade <= 0 ) throw new IllegalArgumentException("O quantidade invalida deve ser positiva");
    }
    public double subtotal(){
        return quantidade * produto().valor();
    }
}
