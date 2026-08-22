package Exercicio15;

public class Main {
    public static void main(String[] args) {
        FrameworkComandos framework = new FrameworkComandos();
        framework.registrar(new CalculadoraCommands());

        CommandResult<Integer> soma = framework.executar("somar", 5, 3);
        System.out.println("somar -> " + soma.getValor());

        CommandResult<String> saudacao = framework.executar("saudacao", "Matheus");
        System.out.println("saudacao -> " + saudacao.getValor());

        try {
            framework.executar("somar", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado -> " + e.getMessage());
        }

        try {
            framework.executar("somar", "cinco", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado -> " + e.getMessage());
        }

        try {
            framework.executar("apagarTudo");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado -> " + e.getMessage());
        }
    }
}