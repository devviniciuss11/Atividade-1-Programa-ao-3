package Exercicio13;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaDadosEntity {

    private final String tabela;
    private final Field campoId;
    private final List<Field> colunas = new ArrayList<>();

    public MetaDadosEntity(Class<?> classeEntidade) {
        if (!classeEntidade.isAnnotationPresent(Entity.class)) {
            throw new IllegalArgumentException(
                    classeEntidade.getName() + " não é uma entidade (faltou @Entity)");
        }

        this.tabela = classeEntidade.getAnnotation(Entity.class).tabela();

        Field idEncontrado = null;
        for (Field campo : classeEntidade.getDeclaredFields()) {
            campo.setAccessible(true);

            if (campo.isAnnotationPresent(Id.class)) {
                idEncontrado = campo;
            }
            if (campo.isAnnotationPresent(Column.class)) {
                colunas.add(campo);
            }
        }

        if (idEncontrado == null) {
            throw new IllegalArgumentException(
                    classeEntidade.getName() + " não possui campo @Id");
        }
        this.campoId = idEncontrado;
    }

    public String getTabela() { return tabela; }
    public Field getCampoId() { return campoId; }
    public List<Field> getColunas() { return colunas; }

    public String nomeColuna(Field campo) {
        return campo.getAnnotation(Column.class).nome();
    }
}