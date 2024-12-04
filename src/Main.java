import Estoque.Estoque;
import Pessoas.Fornecedor;
import Pessoas.Funcionario;
import Produtos.Alimento;
import Produtos.Bebida;
import Transacoes.Entrada;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean menu = true;
        Fornecedor fornecedor = new Fornecedor();
        Funcionario funcionario = new Funcionario();
        Estoque estoque = new Estoque();
        Entrada entrada = new Entrada();

        while (menu) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Produto");
            System.out.println("2 - Estoque");
            System.out.println("3 - Funcionario");
            System.out.println("4 - Fornecedor");
            System.out.println("5 - Transacoes");
            System.out.println("6 - Fechar Menu");
            int selecao = scanner.nextInt();

            switch (selecao) {
                case 1:
                    System.out.println("Produto");
                    System.out.println("1- Adicionar");
                    System.out.println("2- Remover");
                    System.out.println("3- Voltar");
                    int selecao2 = scanner.nextInt();
                    switch (selecao2) {
                        case 1:
                            System.out.println("Tipo: ");
                            System.out.println("1- Alimento");
                            System.out.println("2- Bebida");
                            int selecao3 = scanner.nextInt();

                            System.out.println("Id: ");
                            int idProduto = scanner.nextInt();
                            System.out.println("Nome: ");
                            String nome = scanner.next();
                            System.out.println("Quantidade: ");
                            int quantidade = scanner.nextInt();
                            System.out.println("Preço: ");
                            int preco = scanner.nextInt();

                            if (selecao3 == 1) {
                                Alimento alimento = new Alimento(idProduto, nome, quantidade, preco);
                                alimento.adicionarProduto();
                                entrada.transacao(nome, quantidade);
                            } else if (selecao3 == 2) {
                                Bebida bebida = new Bebida(idProduto, nome, quantidade, preco);
                                bebida.adicionarProduto();
                                entrada.transacao(nome, quantidade);
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Id do produto a remover: ");
                                int id = scanner.nextInt();
                                estoque.removerProdutoDoEstoque(id);
                            } catch (IOException e) {
                                System.out.println("Erro: " + e.getMessage());
                            } catch (CsvValidationException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 2:
                    System.out.println("Estoque");
                    System.out.println("1- Ver Estoque");
                    System.out.println("2- Limpar Estoque");
                    System.out.println("3- Quantidade de produtos");
                    System.out.println("4- Voltar");
                    int selecaoEstoque = scanner.nextInt();
                    switch (selecaoEstoque) {
                        case 1:
                            try {
                                estoque.visualizarDados();
                            } catch (IOException e) {
                                System.out.println("Erro: " + e.getMessage());
                            } catch (CsvValidationException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Informe a senha para limpar o estoque: ");
                            String senha = scanner.next();
                            if (senha.equals("1234")) {
                                try {
                                    estoque.removerDados();
                                } catch (IOException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                } catch (CsvValidationException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                System.out.println("Estoque limpo com sucesso");
                            }
                            break;
                        case 3:
                            estoque.quantidadeDeProtudos();
                        case 4:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 3:
                    System.out.println("Funcionario");
                    System.out.println("1- Cadastrar Funcionario");
                    System.out.println("2- Remover Funcionario");
                    System.out.println("3- Ver funcionarios");
                    System.out.println("4- Voltar");
                    int selecaoFuncionario = scanner.nextInt();
                    switch (selecaoFuncionario) {
                        case 1:
                            System.out.println("Id: ");
                            int id = scanner.nextInt();
                            System.out.println("Nome: ");
                            String nome = scanner.next();
                            System.out.println("Cargo: ");
                            String cargo = scanner.next();
                            Funcionario funcionario1 = new Funcionario(id, nome, cargo);
                            funcionario1.adicionar();
                            break;
                        case 2:
                            System.out.println("Id da pessoa a remover: ");
                            int idRemover = scanner.nextInt();
                            funcionario.remover(idRemover);
                            break;
                        case 3:
                            funcionario.visualizarDados();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 4:
                    System.out.println("Fornecedor");
                    System.out.println("1- Cadastrar Fornecedor");
                    System.out.println("2- Remover Fornecedor");
                    System.out.println("3- Ver fornecedores");
                    System.out.println("4- Voltar");
                    int selecaoFornecedor = scanner.nextInt();
                    switch (selecaoFornecedor) {
                        case 1:
                            System.out.println("Id: ");
                            int id = scanner.nextInt();
                            System.out.println("Nome: ");
                            String nome = scanner.next();
                            String cargo = "Fornecedor";
                            Fornecedor fornecedor1 = new Fornecedor(id, nome, cargo);
                            fornecedor1.adicionar();
                            break;
                        case 2:
                            System.out.println("Id da pessoa a remover: ");
                            int idRemover = scanner.nextInt();
                            fornecedor.remover(idRemover);
                            break;
                        case 3:
                            fornecedor.visualizarDados();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 5:
                    System.out.println("Transacoes");
                    System.out.println("1- Ver Transacoes");
                    System.out.println("2- Limpar Transacoes");
                    System.out.println("3- Voltar");
                    int selecaoTransacoes = scanner.nextInt();
                    switch (selecaoTransacoes) {
                        case 1:
                            entrada.visualizarDados();
                            break;
                        case 2:
                            System.out.println("Informe a senha para limpar as Transacoes: ");
                            String senhaTransacoes = scanner.next();
                            if (senhaTransacoes.equals("abcd")) {
                                entrada.removerDados();
                                System.out.println("Transacoes limpa com sucesso");
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 6:
                    menu = false;
                    System.out.println("Programa Finalizado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

    }
}