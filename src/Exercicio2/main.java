package Exercicio2;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[]Args){

        List<Funcionario> folha = List.of(
                new Gerente("Alisson","1234442",1621.5),
                new Desenvolvedor("Matheus","00000001",1621.5),
                new Estagiario("Vinicius","00000001",1621.5)
        );

        for( Funcionario f : folha ){
            System.out.printf("%s: Cpf:%s R$ %.2f%n", f.getNome(), f.getCpf(), f.calcularSalario());
        }
    }
}
