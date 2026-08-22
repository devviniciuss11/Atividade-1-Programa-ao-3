package Exercicio15;

public class CalculadoraCommands {

    @Command(nome = "somar")
    public int somar(int a, int b) {
        return a + b;
    }

    @Command(nome = "saudacao")
    public String saudacao(String nome) {
        return "Olá, " + nome + "!";
    }
}