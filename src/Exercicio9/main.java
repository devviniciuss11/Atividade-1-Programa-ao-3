package Exercicio9;

import java.util.List;


public class main {
    public static void main(String[] args) {

        Validador<Cliente> validadorCliente = new Validador<Cliente>()
                .adicionarRegras(Regras.obrigatorio(Cliente::nome, "Nome"))
                .adicionarRegras(Regras.obrigatorio(Cliente::email, "Email"))
                .adicionarRegras(Regras.condicao(c -> c.email() == null || c.email().contains("@"), "Email invalido"))
                .adicionarRegras(Regras.maiorQue(Cliente::idade, 17, "Idade"));

        Validador<Produto> validadorProduto = new Validador<Produto>()
                .adicionarRegras(Regras.obrigatorio(Produto::nome, "Nome do produto"))
                .adicionarRegras(Regras.maiorQue(Produto::preco, 0, "Preço"))
                .adicionarRegras(Regras.condicao(p -> p.estoque() >= 0, "Estoque não pode ser negativo"));

        Validador<Pedido> validadorPedido = new Validador<Pedido>()
                .adicionarRegras(Regras.condicao(p -> !p.itens().isEmpty(), "Pedido deve ter ao menos um item"))
                .adicionarRegras(Regras.maiorQue(Pedido::valorTotal, 0, "Valor total"));

        System.out.println(" ==== Invalidos ==== ");
        Cliente cliente = new Cliente("", "Igoremail", 15);
        Produto produto = new Produto("Caderno", -10, 5);
        Pedido pedido = new Pedido(cliente, List.of(), 0);

        imprimir("Cliente: ", validadorCliente.validar(cliente));
        imprimir("Produto: ", validadorProduto.validar(produto));
        imprimir("Pedido: ", validadorPedido.validar(pedido));

        System.out.println(" ");

        System.out.println(" ==== Validos ==== ");

        Cliente clientevalido = new Cliente("Igor", "Igor@gmail.com", 19);
        Produto produtovalido = new Produto("5090", 29.955, 5);
        Pedido pedidovalido = new Pedido(clientevalido, List.of(), 29.000);

        System.out.println(clientevalido);
        imprimir("Cliente: ", validadorCliente.validar(clientevalido));
        System.out.println(produtovalido);
        imprimir("Produto: ", validadorProduto.validar(produtovalido));

    }

    private static void imprimir(String rotulo, List<String> erros) {
        System.out.println("Validação de " + rotulo + ":");
        if (erros.isEmpty()) {
            System.out.println("  OK, nenhum erro encontrado.");
        } else {
            erros.forEach(e -> System.out.println("  - " + e));
        }
        System.out.println();
    }


}

