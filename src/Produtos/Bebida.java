package Produtos;

public class Bebida extends Produto{

    public Bebida(int id, String nome, int quatidade, double preço) {
        super(id, nome, quatidade, preço);
        this.tipo = "Bebida";
    }
}
