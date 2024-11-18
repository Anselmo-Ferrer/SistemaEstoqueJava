import Estoque.Estoque;
import Pessoas.Fornecedor;
import Pessoas.Funcionario;
import Transacoes.Entrada;
import com.opencsv.CSVWriter;

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
        Fornecedor fornecedor = new Fornecedor();
        Entrada entrada = new Entrada();

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
                    estoque.adicionarPrdouto();
                } else if (selecao2 == 2) {
                    estoque.editarProduto();
                } else if (selecao2 == 3) {
                    estoque.removerProduto();
                }
            }

            else if (selecao1 == 2) {
                System.out.println("Estoque");
                System.out.println("1- Ver Estoque");
                System.out.println("2- Limpar Estoque");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    estoque.visualizarDados();
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
                    funcionario.removerPessoa();
                }
            }

            else if (selecao1 == 4) {
                System.out.println("Fornecedor");
                System.out.println("1- Cadastrar Fornecedor");
                System.out.println("2- Remover Fornecedor");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    fornecedor.adionarPessoa();
                } else if (selecao2 == 2) {
                    fornecedor.removerPessoa();
                }
            }

            else if (selecao1 == 5) {
                System.out.println("Transacoes");
                System.out.println("1- Ver Transacoes");
                System.out.println("2- Limpar Transacoes");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    entrada.visualizarDados();
                } else if (selecao2 == 2) {
                    System.out.println("Informe a senha para limpar as Transacoes: ");
                    String senha = scanner.next();
                    if (senha.equals("abcd")) {
                        entrada.removerDados();
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