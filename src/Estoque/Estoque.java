package Estoque;

import Excepetions.EstoqueVazio;
import Interfaces.DeletarDados;
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

public class Estoque implements MostrarDados, DeletarDados {

    public void removerProduto() {
        Saida saida = new Saida();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do produto a remover: ");
        int id = scanner.nextInt();

        String arquivoCSV = "src/BancoDeDados/estoque.csv";
        List<String[]> linhas = new ArrayList<>();
        String nomeProduto = "";
        int quantidadeProduto = 0;

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equals(String.valueOf(id))) {
                    nomeProduto = linha[2];
                    quantidadeProduto = Integer.parseInt(linha[3]);
                }
                if (!linha[0].equals(String.valueOf(id))) {
                    linhas.add(linha);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas);
            System.out.println("Produto com ID " + id + " removido.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        saida.transacao(nomeProduto, quantidadeProduto);
    }

    public void editarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do produto a editar: ");
        int id = scanner.nextInt();

        String arquivoCSV = "src/BancoDeDados/estoque.csv";
        List<String[]> linhas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equals(String.valueOf(id))) {
                    System.out.println("Produto atual: " + String.join(", ", linha));
                    System.out.println("Escolha o que deseja editar: ");
                    System.out.println("1 - Tipo");
                    System.out.println("2 - Nome");
                    System.out.println("3 - Quantidade");
                    System.out.println("4 - Preço");
                    int selecao = scanner.nextInt();
                    scanner.nextLine();

                    switch (selecao) {
                        case 1:
                            System.out.println("Novo tipo: ");
                            linha[1] = scanner.nextLine();
                            break;
                        case 2:
                            System.out.println("Novo nome: ");
                            linha[2] = scanner.nextLine();
                            break;
                        case 3:
                            System.out.println("Nova quantidade: ");
                            linha[3] = String.valueOf(scanner.nextInt());
                            break;
                        case 4:
                            System.out.println("Novo preço: ");
                            linha[4] = String.valueOf(scanner.nextDouble());
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    System.out.println("Produto atualizado: " + String.join(", ", linha));
                }
                linhas.add(linha);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas);
            System.out.println("Alterações salvas no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visualizarDados() {
        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/estoque.csv"))) {
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
    public void removerDados() {
        String estoqueCsv = "src/BancoDeDados/estoque.csv";

        try (CSVReader reader = new CSVReader(new FileReader(estoqueCsv))) {
            String[] linha = reader.readNext();
            linha = reader.readNext();

            if (linha == null) {
                throw new EstoqueVazio("O estoque já está vazio!");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(estoqueCsv))) {
            String[] cabecalho = {"Id", "Tipo", "Nome", "Quantidade", "Preço"};
            writer.writeNext(cabecalho);
            System.out.println("O estoque foi limpo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
