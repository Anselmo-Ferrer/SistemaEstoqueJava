package Pessoas;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funcionario extends Pessoa {


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
}



