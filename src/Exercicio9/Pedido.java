package Exercicio9;

import java.util.List;

public record Pedido(Cliente cliente, List<Produto> itens, double valorTotal) {}