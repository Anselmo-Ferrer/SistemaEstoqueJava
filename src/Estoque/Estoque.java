package Estoque;

import Interfaces.DeletarDados;
import Interfaces.MostrarDados;
import Transacoes.Entrada;
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

public class Estoque implements DeletarDados, MostrarDados {

    @Override
    public void visualizarDados() {
        try (CSVReader reader = new CSVReader(new FileReader("src/BancoDeDados/estoque.csv"))) {
            String[] linha;
            while (true) {
                try {
                    linha = reader.readNext();
                    if (linha == null) {
                        break;  // Fim do arquivo
                    }
                    System.out.println("Linha: " + String.join(", ", linha));
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPrdouto() {
        Entrada entrada = new Entrada();

        // -------------PARTE DE CAPTURA DE INFORMACOES------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id: ");
        int id = scanner.nextInt();
        System.out.println("Tipo: ");
        System.out.println("1- Alimento");
        System.out.println("2- Bebida");
        String tipo;
        int selecaoTipo = scanner.nextInt();
        if (selecaoTipo == 1) {
            tipo = "Alimento";
        } else {
            tipo = "Bebida";
        }
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.println("Preco: ");
        double preco = scanner.nextDouble();


        // -------------PARTE DE ADICIONAR O PRODUTO NO ARQUIVO------
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/BancoDeDados/estoque.csv", true))) {  // O "true" abre o arquivo em modo append
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

    public void removerProduto() {
        Saida saida = new Saida();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do produto a remover: ");
        int id = scanner.nextInt();

        String arquivoCSV = "src/BancoDeDados/estoque.csv";
        List<String[]> linhas = new ArrayList<>(); // Para armazenar as linhas do arquivo
        String nomeProduto = "";
        int quantidadeProduto = 0;

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equals(String.valueOf(id))) {
                    nomeProduto = linha[2];
                    quantidadeProduto = Integer.parseInt(linha[3]);
                }
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
            System.out.println("Produto com ID " + id + " removido.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        saida.transacaoConfirmar(nomeProduto, quantidadeProduto);
    }

    public void editarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do produto a editar: ");
        int id = scanner.nextInt();

        String arquivoCSV = "src/BancoDeDados/estoque.csv";
        List<String[]> linhas = new ArrayList<>(); // Para armazenar as linhas do arquivo

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                // Verifica se a linha corresponde ao ID informado
                if (linha[0].equals(String.valueOf(id))) {
                    System.out.println("Produto atual: " + String.join(", ", linha));
                    System.out.println("Escolha o que deseja editar: ");
                    System.out.println("1 - Tipo");
                    System.out.println("2 - Nome");
                    System.out.println("3 - Quantidade");
                    System.out.println("4 - Preço");
                    int selecao = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha após o número

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
                // Adiciona a linha (editada ou não) à lista
                linhas.add(linha);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Reescreve o arquivo CSV com as alterações
        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(linhas); // Escreve todas as linhas (alteradas ou não)
            System.out.println("Alterações salvas no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerDados() {
        String estoqueCsv = "src/BancoDeDados/estoque.csv";

        try (FileWriter writer = new FileWriter(estoqueCsv, false)) {
            System.out.println("O estoque foi limpo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
