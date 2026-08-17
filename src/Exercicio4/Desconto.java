package Exercicio4;

import java.util.List;

public class Desconto {

    public static double aplicar(double valor, List<RDesconto> regras) {
        double resultado = valor;
        for (RDesconto regra : regras) resultado = regra.aplicar(resultado);
        return resultado;
    }
}
