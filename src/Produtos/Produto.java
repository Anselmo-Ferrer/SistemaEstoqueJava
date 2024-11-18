package Produtos;

public abstract class Produto {
    protected int id;
    protected String tipo;
    protected String nome;
    protected int quatidade;
    protected double preço;

    public Produto(int id, String nome, int quatidade, double preço) {
        this.id = id;
        this.nome = nome;
        this.quatidade = quatidade;
        this.preço = preço;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public double getPreço() {
        return preço;
    }
}
