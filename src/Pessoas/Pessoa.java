package Pessoas;

import Interfaces.DeletarDados;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Pessoa implements DeletarDados {
    protected int id;
    protected String nome;
    protected String cargo;

    public abstract void adionarPessoa();

    public abstract void removerPessoa();

    @Override
    public void removerDados() {
        String pessoasCsv = "src/BancoDeDados/pessoas.csv";

        try (FileWriter writer = new FileWriter(pessoasCsv, false)) {
            System.out.println("Os dados das pessoas foram deletados!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return  "ID: " + id + ", Nome: " + nome + ", Cargo: " + cargo;
    }
}
