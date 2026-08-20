package Exercicio7;


import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> inteiros = Arrays.asList(10,20,30,40);
        List<Double> doubles = Arrays.asList(5.5,6.3,4.1,10.3);

        System.out.println(" === Numeros Escolhidos === ");
        Numero.imprimirNumeros(inteiros);

        System.out.println(" === Calculos === ");
        System.out.println("Soma: " + Numero.Soma(inteiros));
        System.out.println("Media: " + Numero.Media(inteiros));
        System.out.println("Maior: " + Numero.Maior(inteiros));


        System.out.println(Numero.maiorComparable(doubles));

        //PECS é uma regra para saber quando usar extends e quando usar super em Generics com wildcards.
        //Producer (extends) → quando você lê dados da coleção.
        //Consumer (super) → quando você adiciona dados à coleção.



    }
}
