package Exercicio7;

import java.util.*;

public class Numero{
    public static double Soma(Collection<? extends Number> numeros) {
        double total = 0;

        for (Number numero : numeros) {
            total += numero.doubleValue();
        }
        return total;
    }

    //Média
    public static double Media(Collection<? extends Number> numeros) {
        if (numeros.isEmpty()) {
            return 0;
        }
        return Soma(numeros) / numeros.size();
    }

    //Maior Valor
    public static double Maior(Collection<? extends Number> numeros){
        if (numeros.isEmpty()){
            throw new IllegalArgumentException("Coleção vazia!");
        }
        double Maior = Double.NEGATIVE_INFINITY;

        for (Number numero : numeros) {
            if (numero.doubleValue() > Maior){
                Maior = numero.doubleValue();
            }
        }
        return Maior;
    }

    //Lê os valores
    public static void imprimirNumeros (Collection<? extends Number> numeros){
        for (Number numero : numeros) {
            System.out.println(numero);
        }
    }

    //Adicionar numeros
    public static void adicionaNumeros(Collection<? super Integer> numeros) {
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
    }

    //comparable para encontrar o maior numero
    public static <T extends Comparable<T>> T maiorComparable(Collection<T> elementos) {
        if (elementos.isEmpty()) {
            throw new IllegalArgumentException("Coleção vazia");
        }
        T maior = elementos.iterator().next();

        for (T elemento : elementos) {
            if (elemento.compareTo(maior) > 0 ) {
                maior = elemento;
            }
        }
        return maior;
    }


}