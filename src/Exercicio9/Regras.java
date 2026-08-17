package Exercicio9;


import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Regras {

    private Regras() {}

    public static <T> RegraValidacao<T> obrigatorio(Function<T, String> campo, String nome) {
        return obj -> {
            String valor = campo.apply(obj);
            return (valor == null || valor.isBlank())
                    ? Optional.of(nome + " é obrigatório")
                    : Optional.empty();
        };
    }

    public static <T> RegraValidacao<T> tamanhoMinimo(Function<T, String> campo, int minimo, String nome) {
        return obj -> {
            String valor = campo.apply(obj);
            return (valor != null && valor.length() < minimo)
                    ? Optional.of(nome + " deve ter no mínimo " + minimo + " caracteres")
                    : Optional.empty();
        };
    }

    public static <T> RegraValidacao<T> maiorQue(Function<T, ? extends Number> campo, double limite, String nome) {
        return obj -> {
            double valor = campo.apply(obj).doubleValue();
            return (valor <= limite)
                    ? Optional.of(nome + " deve ser maior que " + limite)
                    : Optional.empty();
        };
    }

    public static <T> RegraValidacao<T> condicao(Predicate<T> condicao, String mensagemErro) {
        return obj -> condicao.test(obj) ? Optional.empty() : Optional.of(mensagemErro);
    }
}

