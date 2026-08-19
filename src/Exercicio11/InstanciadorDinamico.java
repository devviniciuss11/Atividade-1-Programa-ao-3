package Exercicio11;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class InstanciadorDinamico {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome completo da classe: ");
        String nomeClasse = scanner.nextLine();

        try {
            Class<?> classe = Class.forName(nomeClasse);

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();

            System.out.print("Digite o estoque: ");
            int estoque = scanner.nextInt();

            System.out.print("Digite a categoria: ");
            scanner.nextLine();
            String categoria = scanner.nextLine();

            Constructor<?> construtor = classe.getConstructor(
                    int.class,
                    String.class,
                    double.class,
                    int.class,
                    String.class
            );

            Object objeto = construtor.newInstance(
                    1,
                    nome,
                    preco,
                    estoque,
                    categoria
            );

            System.out.println("\nObjeto criado com sucesso!");
            System.out.println("Classe: " + objeto.getClass().getName());

        } catch (ClassNotFoundException e) {

            System.out.println("Classe não encontrada.");

        } catch (NoSuchMethodException e) {

            System.out.println("Construtor compatível não encontrado.");

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {

            System.out.println("Erro ao criar o objeto: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
