package Estoque;

import Excepetions.EstoqueVazio;
import Interfaces.DeletarDados;
import Interfaces.MostrarDados;
import Produtos.Produto;
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

public class Estoque implements MostrarDados, DeletarDados {
    private String estoqueCSV = "src/BancoDeDados/estoque.csv";

    public void removerProdutoDoEstoque(int id) throws IOException, CsvValidationException {
        Saida saida = new Saida();

        List<String[]> linhas = new ArrayList<>();
        String nomeProduto = "";
        int quantidadeProduto = 0;

        try (CSVReader reader = new CSVReader(new FileReader(estoqueCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equals(String.valueOf(id))) {
                    nomeProduto = linha[2];
                    quantidadeProduto = Integer.parseInt(linha[3]);
                } else {
                    linhas.add(linha);
                }
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(estoqueCSV))) {
            writer.writeAll(linhas);
            System.out.println("Produto com ID " + id + " removido.");
        }

        saida.transacao(nomeProduto, quantidadeProduto);
    }

    @Override
    public void visualizarDados() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(estoqueCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                System.out.println(String.join(", ", linha));
            }
        }
    }

    @Override
    public void removerDados() throws IOException, CsvValidationException, EstoqueVazio {
        try (CSVReader reader = new CSVReader(new FileReader(estoqueCSV))) {
            String[] linha = reader.readNext();
            linha = reader.readNext();

            if (linha == null) {
                throw new EstoqueVazio("O estoque já está vazio!");
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(estoqueCSV))) {
            String[] cabecalho = {"Id", "Tipo", "Nome", "Quantidade", "Preço"};
            writer.writeNext(cabecalho);
            System.out.println("O estoque foi limpo!");
        }
    }

    public void quantidadeDeProtudos() {
        int quantidadeProdutos = 0;

        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/estoque.csv"))) {
            while (reader.readNext() != null) {
                quantidadeProdutos++;
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        quantidadeProdutos = quantidadeProdutos - 1;

        System.out.println("Quantidade de produtos: " + quantidadeProdutos);
    }

}
