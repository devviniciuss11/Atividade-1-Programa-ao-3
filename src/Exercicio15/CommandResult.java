package Exercicio15;

public class CommandResult<T> {
    private final T valor;

    public CommandResult(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}