package Pessoas;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String cargo;

    public abstract void adionarPessoa();


    @Override
    public String toString() {
        return  "ID: " + id + ", Nome: " + nome + ", Cargo: " + cargo;
    }
}
