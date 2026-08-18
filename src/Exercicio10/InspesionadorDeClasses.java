package Exercicio10;
import java.lang.reflect.*;
import java.util.Scanner;

public class InspesionadorDeClasses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome completo da classe: ");
        System.out.println("\nEx: Nome -> Package.Class");
        String nome = scanner.nextLine();

        try {

            Class<?> classe = Class.forName(nome);

            System.out.println("\n=== CLASSE ===");
            System.out.println("Nome: " + classe.getName());
            System.out.println("Modificadores: "
                    + Modifier.toString(classe.getModifiers()));

            System.out.println("\n=== ATRIBUTOS ===");

            for (Field atributo : classe.getDeclaredFields()) {

                System.out.println(
                        Modifier.toString(atributo.getModifiers()) + " " + atributo.getType().getSimpleName() + " " + atributo.getName());

                if (Modifier.isPrivate(atributo.getModifiers())) {
                    System.out.println("  -> Atributo privado");
                }
            }

            System.out.println("\n=== CONSTRUTORES ===");
            for (Constructor<?> construtor : classe.getDeclaredConstructors()) {

                System.out.print(
                        Modifier.toString(construtor.getModifiers()) + " " + construtor.getName() + "(");

                Class<?>[] parametros = construtor.getParameterTypes();

                for (int i = 0; i < parametros.length; i++) {
                    System.out.print(parametros[i].getSimpleName());

                    if (i < parametros.length - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println(")");
            }

            System.out.println("\n=== MÉTODOS PÚBLICOS ===");
            for (Method metodo : classe.getMethods()) {
                System.out.println(
                        metodo.getName() + " -> " + metodo.getReturnType().getSimpleName());
            }

            System.out.println("\n=== MÉTODOS DA PRÓPRIA CLASSE ===");

            for (Method metodo : classe.getDeclaredMethods()) {
                System.out.print(
                        Modifier.toString(metodo.getModifiers()) + " " + metodo.getReturnType().getSimpleName() + " " + metodo.getName() + "(");

                Class<?>[] parametros = metodo.getParameterTypes();

                for (int i = 0; i < parametros.length; i++) {
                    System.out.print(parametros[i].getSimpleName());

                    if (i < parametros.length - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println(")");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada.");
        }

        scanner.close();
    }
}