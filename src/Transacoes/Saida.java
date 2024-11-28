package Transacoes;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Saida extends Transacoes{

    @Override
    public void transacao(String nome, int quantidade) {
        int numeroDeLinhas = 0;

        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/transacoes.csv"))) {
            while (reader.readNext() != null) {
                numeroDeLinhas++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        id = numeroDeLinhas;
        String tipo = "Saida";
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
    public String toString() {
        return super.toString();
    }
}
