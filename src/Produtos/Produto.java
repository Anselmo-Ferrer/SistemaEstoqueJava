package Produtos;

public abstract class Produto {
    protected int id;
    protected String nome;
    protected int quantidade;
    protected double preco;

    public Produto(int id,String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public abstract void adicionarProduto();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: " + preco;
    }

    public String toString(boolean detalhado) {
        if (detalhado) {
            return "Id: '" + id + ", Nome: '" + nome + ", Quantidade: " + quantidade + ", Preço: " + preco;
        }
        return this.toString();
    }
}
