package Produtos;

import Excepetions.QuantidadeMaiorQueZero;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bebida extends Produto{
    private String tipo = "Bebida";

    public Bebida(int id, String nome, int quantidade, double preco) {
        super(id, nome, quantidade, preco);
    }

    @Override
    public void adicionarProduto() {

        if (super.quantidade <= 0) {
            throw new QuantidadeMaiorQueZero("A quantidade deve ser maior que zero.");
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/estoque.csv", true))) {
            String[] produto = {
                    String.valueOf(super.id),
                    this.tipo,
                    super.nome,
                    String.valueOf(super.quantidade),
                    String.valueOf(super.preco)
            };
            writer.writeNext(produto);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
