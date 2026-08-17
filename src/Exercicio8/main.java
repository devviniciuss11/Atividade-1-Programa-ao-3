package Exercicio8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Igor", 3500, "TI"));
        funcionarios.add(new Funcionario("Ana", 4200, "RH"));
        funcionarios.add(new Funcionario("Emanuel", 2800, "Financeiro"));
        funcionarios.add(new Funcionario("Matheus", 5000, "TI"));
        funcionarios.add(new Funcionario("Fernanda", 3200, "RH"));

        // 1. Ordenação natural: por nome
        Collections.sort(funcionarios);
        System.out.println(" ==== Ordem por nome ==== ");
        funcionarios.forEach(System.out::println);

        System.out.println(" ");
        // 2. Salário crescente
        funcionarios.sort(
                Comparator.comparingDouble(Funcionario::getSalario)
        );
        System.out.println(" === Salario Crescente === ");
        funcionarios.forEach(System.out::println);

        System.out.println(" ");
        // 3. Salário decrescente
        funcionarios.sort(
                Comparator.comparingDouble(Funcionario::getSalario).reversed()
        );
        System.out.println(" === Salario Decrescente === ");
        funcionarios.forEach(System.out::println);

        System.out.println(" ");
        // 4. Ordenação por setor
        funcionarios.sort(
                Comparator.comparing(Funcionario::getSetor)
        );
        System.out.println(" === Ordem por Setor === ");
        funcionarios.forEach(System.out::println);

        //Quando utilizar cada um?
        //Comparable: deve ser utilizado quando existe uma ordenação principal ou natural para os objetos.
        //Neste caso, faz sentido considerar o nome como ordenação padrão.
        //Comparator: deve ser utilizado quando existem vários critérios de ordenação,
        //como salário, setor, idade, data de contratação etc.
    }
}
