package Exercicio6;

public class main {
    public static void main(String[] args) {
        Generica<Cliente> clientes = new Generica<>();

        clientes.adicionar(new Cliente("Igor"));
        clientes.adicionar(new Cliente("Vini"));

        System.out.println("Clientes: ");
        System.out.println(clientes.listar());
        System.out.println("      ");

        Cliente cliente = clientes.consultar(0);
        System.out.println("Consultado: " + cliente);
        System.out.println("      ");

        clientes.remover(1);
        System.out.println("Apos remoção do cliente com indice 1: ");
        System.out.println(clientes.listar());
        System.out.println("  ");
        System.out.println("  ");

        Generica<Produto> produtos = new Generica<>();

        produtos.adicionar(new Produto("Notebook"));
        produtos.adicionar(new Produto("Mouse"));

        System.out.println("\nProdutos:");
        System.out.println(produtos.listar());
        System.out.println(" ");
        System.out.println(" ");

        Generica<Pedido> pedidos = new Generica<>();

        pedidos.adicionar(new Pedido(1));
        pedidos.adicionar(new Pedido(2));

        System.out.println("Pedidos:");
        System.out.println(pedidos.listar());

        Pedido pedido = pedidos.consultar(0);
        System.out.println("Pedido consultado: " + pedido);

        //Em uma versão baseada em Object, o principal problema é que o
        // Java não saberia qual tipo de objeto está sendo armazenado.
        // Isso causa perda de segurança de tipos e exige conversões (casts).
    }
}