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
    public void visualizarDados() {
        super.visualizarDados();
    }

    @Override
    public void adionarPessoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id: ");
        int id = scanner.nextInt();
        String tipo = "Funcionario";
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Cargo: ");
        String cargo = scanner.next();

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/pessoas.csv", true))) {  // O "true" abre o arquivo em modo append
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
    public void removerPessoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id da pessoa a remover: ");
        int id = scanner.nextInt();

        String arquivoCSV = "src/BancoDeDados/pessoas.csv";
        List<String[]> linhas = new ArrayList<>(); // Para armazenar as linhas do arquivo

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                // Verifica se a linha tem um ID diferente do que queremos remover
                if (!linha[0].equals(String.valueOf(id))) {
                    linhas.add(linha); // Adiciona à lista se não for para remover
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Reescrevendo o arquivo com as linhas restantes
        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas); // Escreve todas as linhas restantes no arquivo
            System.out.println("Pessoa com ID " + id + " removido.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



