package Produtos;

public abstract class Produto {
    protected int id;
    protected String tipo;
    protected String nome;
    protected int quantidade;
    protected double preco;

    public abstract void adicionarAoEstoque();

    @Override
    public String toString() {
        return "Id: " + id + ", Tipo: '" + tipo + ", Nome: '" + nome + ", Quantidade: " + quantidade + ", preço=" + preco;
    }
}
