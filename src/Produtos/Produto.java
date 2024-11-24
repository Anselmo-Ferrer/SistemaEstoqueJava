package Produtos;

public abstract class Produto {
    protected int id;
    protected String tipo;
    protected String nome;
    protected int quatidade;
    protected double preço;

    public abstract void adicionarAoEstoque();
}
