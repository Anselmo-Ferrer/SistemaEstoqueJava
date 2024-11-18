package Transacoes;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;

public class Entrada extends Transacoes{

    @Override
    public void transacaoConfirmar(String nome, int quantidade) {
        int numeroDeLinhas = 0;

        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/transacoes.csv"))) {
            while (reader.readNext() != null) {
                numeroDeLinhas++; // Incrementa para cada linha lida
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        id = numeroDeLinhas;
        String tipo = "Entrada";
        String produto = nome + " " + quantidade + "x";
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = agora.format(formatter);

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/transacoes.csv", true))) {  // O "true" abre o arquivo em modo append
            String[] transacao = {
                    String.valueOf(id),
                    tipo,
                    produto,
                    dataFormatada

            };
            writer.writeNext(transacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerDados() {
        String transacoesCsv = "src/BancoDeDados/transacoes.csv";

        try (FileWriter writer = new FileWriter(transacoesCsv, false)) {
            System.out.println("As transacoes foram limpas!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
