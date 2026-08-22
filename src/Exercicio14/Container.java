package Exercicio14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Container {

    public static <T> T criar(Class<T> classe) {
        T instancia = instanciar(classe);
        injetarCampos(instancia, classe);

        return instancia;
    }

    private static <T> T instanciar(Class<T> classe) {
        try {

            Constructor<T> construtorVazio = classe.getDeclaredConstructor();
            construtorVazio.setAccessible(true);
            return construtorVazio.newInstance();

        } catch (NoSuchMethodException semConstrutorVazio) {

            return instanciarPorConstrutorComArgumentos(classe);

        } catch (Exception e) {
            throw new DependenciaNaoEncontradaException(
                    "Não foi possível instanciar " + classe.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T instanciarPorConstrutorComArgumentos(Class<T> classe) {
        Constructor<?>[] construtores = classe.getDeclaredConstructors();

        if (construtores.length == 0) {
            throw new DependenciaNaoEncontradaException(
                    "A classe " + classe.getName() + " não possui nenhum construtor utilizável");
        }

        Constructor<?> construtor = construtores[0];
        Class<?>[] tiposParametros = construtor.getParameterTypes();

        Object[] argumentos = new Object[tiposParametros.length];
        for (int i = 0; i < tiposParametros.length; i++) {
            argumentos[i] = criar(tiposParametros[i]);
        }

        try {
            construtor.setAccessible(true);
            return (T) construtor.newInstance(argumentos);
        } catch (Exception e) {
            throw new DependenciaNaoEncontradaException(
                    "Falha ao instanciar " + classe.getName() + " via construtor com argumentos", e);
        }
    }

    private static void injetarCampos(Object instancia, Class<?> classe) {

        for (Field campo : classe.getDeclaredFields()) {

            if (!campo.isAnnotationPresent(Inject.class)) {
                continue;
            }

            Class<?> tipoDependencia = campo.getType();

            try {
                Object dependencia = criar(tipoDependencia);

                campo.setAccessible(true);
                campo.set(instancia, dependencia);

            } catch (DependenciaNaoEncontradaException e) {
                throw new DependenciaNaoEncontradaException(
                        "Não foi possível injetar '" + campo.getName() + "' em "
                                + classe.getSimpleName() + " (tipo requerido: "
                                + tipoDependencia.getName() + ")", e);
            } catch (IllegalAccessException e) {
                throw new DependenciaNaoEncontradaException(
                        "Sem acesso ao campo '" + campo.getName() + "' em " + classe.getName(), e);
            }
        }
    }

    public static class DependenciaNaoEncontradaException extends RuntimeException {
        public DependenciaNaoEncontradaException(String mensagem, Throwable causa) {
            super(mensagem, causa);
        }
        public DependenciaNaoEncontradaException(String mensagem) {
            super(mensagem);
        }
    }
}