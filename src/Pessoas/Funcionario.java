package Pessoas;

import Interfaces.MostrarDados;
import Transacoes.Saida;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {

    @Override
    public void adicionar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id: ");
        int id = scanner.nextInt();
        String tipo = "Funcionario";
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Cargo: ");
        String cargo = scanner.next();

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/pessoas.csv", true))) {
            String[] pessoa = {
                    String.valueOf(id),
                    tipo,
                    nome,
                    cargo

            };
            writer.writeNext(pessoa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id da pessoa a remover: ");
        int id = scanner.nextInt();

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
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas);
            System.out.println("Pessoa com ID " + id + " removido.");
        } catch (IOException e) {
            e.printStackTrace();
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



