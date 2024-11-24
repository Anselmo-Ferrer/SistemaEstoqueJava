package Produtos;

import Excepetions.QuantidadeMaiorQueZero;
import Transacoes.Entrada;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Alimento extends Produto{

    @Override
    public void adicionarAoEstoque() {
        Entrada entrada = new Entrada();

        int numeroDeLinhas = 0;

        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/estoque.csv"))) {
            while (reader.readNext() != null) {
                numeroDeLinhas++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        int id = numeroDeLinhas;

        // -------------PARTE DE CAPTURA DE INFORMACOES------
        Scanner scanner = new Scanner(System.in);
        String tipo = "Alimento";
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        if (quantidade <= 0) {
            throw new QuantidadeMaiorQueZero("A quantidade deve ser maior que zero.");
        }
        System.out.println("Preco: ");
        double preco = scanner.nextDouble();


        // -------------PARTE DE ADICIONAR O PRODUTO NO ARQUIVO------
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/estoque.csv", true))) {
            String[] produto = {
                    String.valueOf(id),
                    tipo,
                    nome,
                    String.valueOf(quantidade),
                    String.valueOf(preco)
            };
            writer.writeNext(produto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        entrada.transacaoConfirmar(nome, quantidade);
    }

}
