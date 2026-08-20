package Exercicio13;

import java.util.HashMap;
import java.util.Map;

public class BancoNaMemoria<T>{
    private final Map<Id,T> linhas = new HashMap<>();

    public void executar(String sql,Object...vlores){
        System.out.println("Executando "+sql);
        System.out.println("Valores -> ");
        for(int i = 0; i < vlores.length; i++){
            if(i > 0){
                System.out.println(", ");
            }
            System.out.println(vlores[i]);

        }
    }
    public void inserir(Id id, T objeto){
        linhas.put(id, objeto);
    }
    public T buscar(Id id){
        return linhas.get(id);
    }

    public void remover(Id id){
        linhas.remove(id);
    }
}
