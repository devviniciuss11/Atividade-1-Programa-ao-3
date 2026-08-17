package Exercicio9;

import java.util.Optional;

@FunctionalInterface
public interface RegraValidacao<T>{
    Optional<String> validar(T objeto);
}
