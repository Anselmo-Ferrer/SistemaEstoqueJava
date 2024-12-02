package Produtos;

public abstract class Produto {
    protected int id;
    protected String tipo;
    protected String nome;
    protected int quantidade;
    protected double preco;

    public abstract void adicionarProduto();

    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Preço: " + preco;
    }

    public String toString(boolean detalhado) {
        if (detalhado) {
            return "Id: " + id + ", Tipo: '" + tipo + "', Nome: '" + nome + "', Quantidade: " + quantidade + ", Preço: " + preco;
        }
        return this.toString();
    }
}
