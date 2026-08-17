package Exercicio5;

import java.util.ArrayList;

public class Carrinho {
    private final ArrayList<ItemCarrinho> meuCarrinho =  new ArrayList<>();

    public void  adicionarItem(ItemCarrinho item){
        meuCarrinho.add(item);
    }

    public void  removerItem(ItemCarrinho item){
        meuCarrinho.remove(item);
    }

    public void removerTodosItems(){
        meuCarrinho.clear();
    }
    public double quantidade(){
        return meuCarrinho.size();
    }
    public double subtotalTotal(){
        return meuCarrinho.stream().mapToDouble(ItemCarrinho::subtotal).sum();
    }

    public double desconto() { return subtotalTotal() >= 200 ? subtotalTotal() * 0.10 : 0; }
    public double frete() { return subtotalTotal() >= 150 ? 0 : 20; }
    public double total() { return subtotalTotal() - desconto() + frete(); }

}
