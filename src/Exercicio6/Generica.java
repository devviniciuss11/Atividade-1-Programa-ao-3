package Exercicio6;

import java.util.ArrayList;
import java.util.List;


public class Generica<T> {
    private List<T> objetos = new ArrayList<>();

    public void adicionar(T objeto) {
        objetos.add(objeto);
    }

    public T consultar(int indice){
        return objetos.get(indice);
    }
    public void atualizar (int indice, T novoObjeto){
        objetos.set(indice, novoObjeto);
    }
    public void remover (int indice) {
        objetos.remove(indice);
    }

    public List<T> listar(){
        return objetos;
    }



}