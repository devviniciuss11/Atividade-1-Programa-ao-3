package Exercicio6;

public class Pedido {

    private int numero;

    public Pedido(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pedido: " + numero;
    }
}