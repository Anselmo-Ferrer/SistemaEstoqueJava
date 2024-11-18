import Estoque.Estoque;
import Pessoas.Fornecedor;
import Pessoas.Funcionario;
import Produtos.Produto;
import Transacoes.Entrada;
import Transacoes.Saida;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String estoque1 = "src/BancoDeDados/estoque.csv";
        String funcionario1 = "src/BancoDeDados/funcionarios.csv";
        String transacoe1 = "src/BancoDeDados/transacoes.csv";

        boolean menu = true;
        Estoque estoque = new Estoque();
        Funcionario funcionario = new Funcionario();
        Entrada entrada = new Entrada();
        Saida saida = new Saida();

        while (menu) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Produto");
            System.out.println("2 - Estoque");
            System.out.println("3 - Funcionario");
            System.out.println("4 - Fornecedor");
            System.out.println("5 - Transacoes");
            System.out.println("6 - Fechar Menu");
            int selecao1 = scanner.nextInt();

            if (selecao1 == 1) {
                System.out.println("Produto");
                System.out.println("1- Adicionar");
                System.out.println("2- Editar");
                System.out.println("3- Remover");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Id: ");
                    int id = scanner1.nextInt();

                    System.out.println("Tipo: ");
                    System.out.println("1- Alimento");
                    System.out.println("2- Bebida");
                    String tipo;
                    int selecaoTipo = scanner1.nextInt();
                    if (selecaoTipo == 1) {
                        tipo = "Alimento";
                    } else {
                        tipo = "Bebida";
                    }
                    System.out.println("Nome: ");
                    String nome = scanner1.next();
                    System.out.println("Quantidade: ");
                    int quantidade = scanner1.nextInt();
                    System.out.println("Preco: ");
                    double preco = scanner1.nextDouble();
                    estoque.adicionarPrdouto(id, tipo, nome, quantidade, preco);
                    entrada.transacaoConfirmar(nome, quantidade);
                } else if (selecao2 == 2) {
                    estoque.editarProduto();
                } else if (selecao2 == 3) {
                    estoque.removerProduto();
                    //saida.transacaoConfirmar(nome, quantidade);
                }
            }

            else if (selecao1 == 2) {
                System.out.println("Estoque");
                System.out.println("1- Ver Estoque");
                System.out.println("2- Limpar Estoque");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    estoque.mostrarDados();
                } else if (selecao2 == 2) {
                    System.out.println("Informe a senha para limpar o estoque: ");
                    String senha = scanner.next();
                    if (senha.equals("1234")) {
                        System.out.println("Estoque limpo com sucesso");
                    }
                }
            }

            else if (selecao1 == 3) {
                System.out.println("Funcionario");
                System.out.println("1- Cadastrar Funcionario");
                System.out.println("2- Remover Funcionario");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    funcionario.adionarPessoa();
                } else if (selecao2 == 2) {
                    // funcionario.removerPessoa();
                }
            }

            else if (selecao1 == 4) {
                System.out.println("Fornecedor");
                System.out.println("1- Cadastrar Fornecedor");
                System.out.println("2- Remover Fornecedor");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    // fornecedor.adionarPessoa();
                } else if (selecao2 == 2) {
                    // fornecedor.removerPessoa();
                }
            }

            else if (selecao1 == 5) {
                System.out.println("Transacoes");
                System.out.println("1- Ver Transacoes");
                System.out.println("2- Limpar Transacoes");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    estoque.mostrarDados();
                } else if (selecao2 == 2) {
                    System.out.println("Informe a senha para limpar as Transacoes: ");
                    String senha = scanner.next();
                    if (senha.equals("abcd")) {
                        System.out.println("Transacoes limpa com sucesso");
                    }
                }
            }

            if (selecao1 == 6) {
                menu = false;
                System.out.println("Programa Finalizado!");
            }
        }


        // --------------------------------------------------------------------
//        try (CSVWriter writer = new CSVWriter(new FileWriter(estoque1))) {
//            String[] cabecalho = {"Id", "Tipo", "Nome", "Quantidade", "Preço"};
//            writer.writeNext(cabecalho);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (CSVWriter writer = new CSVWriter(new FileWriter(funcionario1))) {
//            String[] cabecalho = {"Id", "Tipo", "Nome", "Cargo"};
//            writer.writeNext(cabecalho);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (CSVWriter writer = new CSVWriter(new FileWriter(transacoe1))) {
//            String[] cabecalho = {"Id", "Tipo", "Produto", "Horario"};
//            writer.writeNext(cabecalho);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}