import Estoque.Estoque;
import Pessoas.Fornecedor;
import Pessoas.Funcionario;
import Produtos.Alimento;
import Produtos.Bebida;
import Transacoes.Entrada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean menu = true;
        Alimento alimento = new Alimento();
        Bebida bebida = new Bebida();
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
            int selecao = scanner.nextInt();

            switch (selecao) {
                case 1:
                    System.out.println("Produto");
                    System.out.println("1- Adicionar");
                    System.out.println("2- Editar");
                    System.out.println("3- Remover");
                    System.out.println("4- Voltar");
                    int selecao2 = scanner.nextInt();
                    switch (selecao2) {
                        case 1:
                            System.out.println("Tipo: ");
                            System.out.println("1- Alimento");
                            System.out.println("2- Bebida");
                            int selecao3 = scanner.nextInt();
                            if (selecao3 == 1) {
                                alimento.adicionarAoEstoque();
                            } else if (selecao3 == 2) {
                                bebida.adicionarAoEstoque();
                            }
                            break;
                        case 2:
                            estoque.editarProduto();
                            break;
                        case 3:
                            estoque.removerProduto();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 2:
                    System.out.println("Estoque");
                    System.out.println("1- Ver Estoque");
                    System.out.println("2- Limpar Estoque");
                    System.out.println("3- Voltar");
                    int selecaoEstoque = scanner.nextInt();
                    switch (selecaoEstoque) {
                        case 1:
                            estoque.visualizarDados();
                            break;
                        case 2:
                            System.out.println("Informe a senha para limpar o estoque: ");
                            String senha = scanner.next();
                            if (senha.equals("1234")) {
                                estoque.removerDados();
                                System.out.println("Estoque limpo com sucesso");
                            }
                            break;
                        case 3:
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
                            funcionario.adionarPessoa();
                            break;
                        case 2:
                            funcionario.removerPessoa();
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
                            fornecedor.adionarPessoa();
                            break;
                        case 2:
                            fornecedor.removerPessoa();
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