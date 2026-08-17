package Exercicio2;

public class main {
    public static void main(String[]Args){
        Gerente gerente = new Gerente("Alisson","123444",1621.5);
        System.out.println("salario do Gerente: "+gerente.calcularSalario());

        Estagiario estagiario = new Estagiario("Vinicius","00000001",1621.5);
        System.out.println("salario do Estagiario: "+estagiario.calcularSalario());

        Desenvolvedor desenvolvedor = new Desenvolvedor("Vinicius","00000001",1621.5);
        System.out.println("Salario do desenvolvedor: "+desenvolvedor.calcularSalario());
    }
}
