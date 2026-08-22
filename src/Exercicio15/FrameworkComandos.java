package Exercicio15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FrameworkComandos {

    private final Map<String, Method> metodos = new HashMap<>();
    private final Map<String, Object> instancias = new HashMap<>();

    public void registrar(Object objeto) {
        for (Method metodo : objeto.getClass().getDeclaredMethods()) {
            if (!metodo.isAnnotationPresent(Command.class)) continue;

            String nome = metodo.getAnnotation(Command.class).nome();
            metodo.setAccessible(true);
            metodos.put(nome, metodo);
            instancias.put(nome, objeto);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> CommandResult<T> executar(String nomeComando, Object... args) {
        Method metodo = metodos.get(nomeComando);
        if (metodo == null) {
            throw new IllegalArgumentException("Comando não encontrado: " + nomeComando);
        }

        validarParametros(metodo, args);

        try {
            Object resultado = metodo.invoke(instancias.get(nomeComando), args);
            return new CommandResult<>((T) resultado);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Sem acesso ao método do comando: " + nomeComando, e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Erro ao executar o comando '" + nomeComando + "'", e.getCause());
        }
    }

    private void validarParametros(Method metodo, Object[] args) {
        Class<?>[] esperados = metodo.getParameterTypes();

        if (esperados.length != args.length) {
            throw new IllegalArgumentException(
                    "Comando '" + metodo.getAnnotation(Command.class).nome() + "' espera "
                            + esperados.length + " parâmetro(s), recebeu " + args.length);
        }

        for (int i = 0; i < esperados.length; i++) {
            Class<?> esperado = box(esperados[i]);
            if (args[i] == null || !esperado.isInstance(args[i])) {
                throw new IllegalArgumentException(
                        "Parâmetro " + i + " inválido: esperado " + esperado.getSimpleName()
                                + ", recebido " + (args[i] == null ? "null" : args[i].getClass().getSimpleName()));
            }
        }
    }

    private Class<?> box(Class<?> tipo) {
        if (!tipo.isPrimitive()) return tipo;
        if (tipo == int.class) return Integer.class;
        if (tipo == double.class) return Double.class;
        if (tipo == boolean.class) return Boolean.class;
        if (tipo == long.class) return Long.class;
        return tipo;
    }
}