package Transacoes;

import Interfaces.DeletarDados;
import Interfaces.MostrarDados;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.MonthDay;

public abstract class Transacoes implements MostrarDados, DeletarDados {
    protected int id;
    protected String tipo;
    protected String[] produtos;
    protected int quantidade;
    protected MonthDay dia;

    public abstract void transacaoConfirmar(String nome, int quantidade);

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
            e.printStackTrace();
        }
    }

    @Override
    public void removerDados() {}
}
