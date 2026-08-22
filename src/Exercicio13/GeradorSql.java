package Exercicio13;

import java.lang.reflect.Field;

public class GeradorSql {

    public String insert(MetaDadosEntity meta, Object entidade) throws IllegalAccessException {
        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        for (Field campo : meta.getColunas()) {
            if (colunas.length() > 0) {
                colunas.append(", ");
                valores.append(", ");
            }
            colunas.append(meta.nomeColuna(campo));
            valores.append(campo.get(entidade));
        }

        return "INSERT INTO " + meta.getTabela() + " (" + colunas + ") VALUES (" + valores + ")";
    }

    public String selectPorId(MetaDadosEntity meta, Object id) {
        return "SELECT * FROM " + meta.getTabela()
                + " WHERE " + meta.nomeColuna(meta.getCampoId()) + " = " + id;
    }

    public String delete(MetaDadosEntity meta, Object id) {
        return "DELETE FROM " + meta.getTabela()
                + " WHERE " + meta.nomeColuna(meta.getCampoId()) + " = " + id;
    }
}
