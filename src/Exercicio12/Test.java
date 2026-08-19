package Exercicio12;

public class Test {

    public static void main(String[] args) {

        Usuario usuario = new Usuario(
                1,
                "Matheus",
                "matheus@gmail.com",
                "123456"
        );

        Usuario usuario2 = new Usuario(
                2,
                "Vinicius",
                "Vini@gmail.com",
                "654321"
        );

        Usuario usuario3 = new Usuario(
                3,
                "Igor",
                "Igor@gmail.com",
                "615243"
        );

        String sql = GeradorDeSql.gerarInsert(usuario);
        String sql1 = GeradorDeSql.gerarInsert(usuario2);
        String sql2 = GeradorDeSql.gerarInsert(usuario3);
        System.out.println(sql + "\n" + sql1  + "\n" + sql2);
    }
}