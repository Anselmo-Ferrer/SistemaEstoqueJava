package Pessoas;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fornecedor extends Pessoa {
    private String tipo = "Fornecedor";

    public Fornecedor(int id, String nome, String cargo) {
        super(id, nome, cargo);
    }

    public Fornecedor() {
    }

    @Override
    public void adicionar() {

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/pessoas.csv", true))) {
            String[] pessoa = {String.valueOf(id), tipo, nome, cargo};
            writer.writeNext(pessoa);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void remover(int id) {
        String arquivoCSV = "src/BancoDeDados/pessoas.csv";
        List<String[]> linhas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (!linha[0].equals(String.valueOf(id))) {
                    linhas.add(linha);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas);
            System.out.println("Pessoa com ID " + id + " removido.");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void visualizarDados() {
        super.visualizarDados();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
