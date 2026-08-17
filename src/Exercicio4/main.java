package Exercicio4;

import java.util.List;

public class main {
    public static void main(String[] args) {
        RDesconto Premium = valor -> valor * 0.8;
        RDesconto campanha = valor -> valor -10;
        RDesconto vip = valor -> valor * 0.9;

        test("Cupom Premium",100,List.of(Premium),80);
        test("Valor zero", 90, List.of(Premium, campanha), -20.0);
        test("premiozada", 99., List.of(Premium, campanha), 69.20);
        test("Regra cupom vip",50,List.of(vip),45);


    }
    private static void test (String descricao, double valorInicial, List<RDesconto> regras, double esperado){
        double obtido = Desconto.aplicar(valorInicial, regras);
        boolean ok = Math.abs(obtido - esperado) < 0.0001;
        System.out.printf("[%s] %s -> esperado: %.2f, obtido: %.2f%n",
                ok ? "OK" : "FALHOU", descricao, esperado, obtido);
    }
}
