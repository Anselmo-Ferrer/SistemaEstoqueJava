package Produtos;

public class Alimento extends Produto{

    public Alimento(int id, String nome, int quatidade, double preço) {
        super(id, nome, quatidade, preço);
        this.tipo = "Alimento";
    }


}
