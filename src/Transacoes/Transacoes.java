package Transacoes;

import Interfaces.DeletarDados;
import Interfaces.MostrarDados;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.MonthDay;

public abstract class Transacoes implements MostrarDados, DeletarDados {
    protected int id;
    protected String produto;
    protected MonthDay dia;

    public abstract void transacao(String nome, int quantidade);

    @Override
    public void visualizarDados() {
        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/transacoes.csv"))) {
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
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void removerDados() {
        String transacoesCsv = "src/BancoDeDados/transacoes.csv";

        try (FileWriter writer = new FileWriter(transacoesCsv, false)) {
            System.out.println("As transacoes foram limpas!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Produto: " + produto;
    }

    public String toString(boolean detalhado) {
        if (detalhado) {
            return "Id: " + id + ", Produto: " + produto + ", Dia: " + dia;
        }
        return this.toString();
    }
}
