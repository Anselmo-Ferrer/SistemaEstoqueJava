package Pessoas;

import Interfaces.DeletarDados;
import Interfaces.Gerenciamento;
import Interfaces.MostrarDados;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Pessoa implements Gerenciamento, MostrarDados, DeletarDados {
    protected int id;
    protected String nome;
    protected String cargo;

    public Pessoa(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Pessoa() {
    }

    @Override
    public void adicionar() {}

    @Override
    public void remover(int id) {}

    @Override
    public void visualizarDados() {
        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/pessoas.csv"))) {
            String[] linha;
            while (true) {
                try {
                    linha = reader.readNext();
                    if (linha == null) {
                        break;
                    }
                    System.out.println(String.join(", ", linha));
                } catch (CsvValidationException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void removerDados() {
        String pessoasCsv = "src/BancoDeDados/pessoas.csv";

        try (FileWriter writer = new FileWriter(pessoasCsv, false)) {
            System.out.println("Os dados das pessoas foram deletados!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }

    public String toString(boolean detalhado) {
        if (detalhado) {
            return "ID: " + id + ", Nome: " + nome + ", Cargo: " + cargo;
        }
        return this.toString();
    }
}
