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
    protected String tipo;
    protected String nome;
    protected String cargo;
    @Override
    public void adicionar() {}

    @Override
    public void remover() {}

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
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        return  "ID: " + id + ", Tipo: " + tipo + ", Nome: " + nome + ", Cargo: " + cargo;
    }
}
