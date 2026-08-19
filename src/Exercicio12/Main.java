package Exercicio12;

public class Main {

    public static void main(String[] args) {

        Usuario usuario = new Usuario(
                1,
                "Matheus",
                "matheus@email.com",
                "123456"
        );

        String sql = GeradorDeSql.gerarInsert(usuario);

        System.out.println(sql);
    }
}