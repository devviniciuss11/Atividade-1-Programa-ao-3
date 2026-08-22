package Exercicio13;

import java.util.HashMap;
import java.util.Map;

public class BancoNaMemoria<ID, T> {

    private final Map<ID, T> linhas = new HashMap<>();

    public void executar(String sql) {
        System.out.println("[SQL] " + sql);
    }

    public void inserir(ID id, T objeto) { linhas.put(id, objeto); }
    public T buscar(ID id) { return linhas.get(id); }
    public void remover(ID id) { linhas.remove(id); }
}
