package Exercicio12;
import java.lang.reflect.Field;

public class GeradorDeSql {

    public static String gerarInsert(Object objeto) {

        Class<?> classe = objeto.getClass();

        Tabela tabela = classe.getAnnotation(Tabela.class);

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        for (Field campo : classe.getDeclaredFields()) {

            Coluna coluna = campo.getAnnotation(Coluna.class);

            if (coluna == null) {
                continue;
            }

            campo.setAccessible(true);

            try {

                Object valor = campo.get(objeto);

                if (colunas.length() > 0) {
                    colunas.append(", ");
                    valores.append(", ");
                }

                colunas.append(coluna.nome());

                if (valor instanceof String) {
                    valores.append("'").append(valor).append("'");
                } else {
                    valores.append(valor);
                }

            } catch (IllegalAccessException e) {
                System.out.println("Erro ao acessar o campo.");
            }
        }

        return "INSERT INTO "
                + tabela.nome()
                + " (" + colunas
                + ") \nVALUES ("
                + valores
                + ");";
    }
}