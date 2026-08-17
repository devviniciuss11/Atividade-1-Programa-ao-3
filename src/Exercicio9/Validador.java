package Exercicio9;


import java.util.ArrayList;
import java.util.List;

public class Validador<T> {

    private final List<RegraValidacao<T>> regras = new ArrayList<>();

    public Validador<T> adicionarRegras(RegraValidacao<T> regra) {
        regras.add(regra);
        return this;
    }
    public List<String> validar(T objeto) {
        List<String> erros = new ArrayList<>();

        for (RegraValidacao<T> regra : regras) {
            regra.validar(objeto).ifPresent(erros::add);
        }
        return erros;
    }

    public boolean estaValido(T objeto) {
        return validar(objeto).isEmpty();
    }

}