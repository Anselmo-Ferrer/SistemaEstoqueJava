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
            int selecao1 = scanner.nextInt();

            if (selecao1 == 1) {
                System.out.println("Produto");
                System.out.println("1- Adicionar");
                System.out.println("2- Editar");
                System.out.println("3- Remover");
                System.out.println("4- Voltar");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    System.out.println("Tipo: ");
                    System.out.println("1- Alimento");
                    System.out.println("2- Bebida");
                    int selecao3 = scanner.nextInt();
                    if (selecao3 == 1) {
                        alimento.adicionarAoEstoque();
                    } else if (selecao3 == 2) {
                        bebida.adicionarAoEstoque();
                    }
                } else if (selecao2 == 2) {
                    estoque.editarProduto();
                } else if (selecao2 == 3) {
                    estoque.removerProduto();
                } else if (selecao2 == 4) {
                    continue;
                }
            }

            else if (selecao1 == 2) {
                System.out.println("Estoque");
                System.out.println("1- Ver Estoque");
                System.out.println("2- Limpar Estoque");
                System.out.println("3- Voltar");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    estoque.visualizarDados();
                } else if (selecao2 == 2) {
                    System.out.println("Informe a senha para limpar o estoque: ");
                    String senha = scanner.next();
                    if (senha.equals("1234")) {
                        estoque.removerDados();
                        System.out.println("Estoque limpo com sucesso");
                    }
                } else if (selecao2 == 3) {
                    continue;
                }
            }

            else if (selecao1 == 3) {
                System.out.println("Funcionario");
                System.out.println("1- Cadastrar Funcionario");
                System.out.println("2- Remover Funcionario");
                System.out.println("3- Ver funcionarios");
                System.out.println("4- Voltar");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    funcionario.adionarPessoa();
                } else if (selecao2 == 2) {
                    funcionario.removerPessoa();
                } else if (selecao2 == 3) {
                    funcionario.visualizarDados();
                } else if (selecao2 == 4) {
                    continue;
                }
            }

            else if (selecao1 == 4) {
                System.out.println("Fornecedor");
                System.out.println("1- Cadastrar Fornecedor");
                System.out.println("2- Remover Fornecedor");
                System.out.println("3- Ver funcionarios");
                System.out.println("4- Voltar");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    fornecedor.adionarPessoa();
                } else if (selecao2 == 2) {
                    fornecedor.removerPessoa();
                } else if (selecao2 == 3) {
                    fornecedor.visualizarDados();
                } else if (selecao2 == 4) {
                    continue;
                }
            }

            else if (selecao1 == 5) {
                System.out.println("Transacoes");
                System.out.println("1- Ver Transacoes");
                System.out.println("2- Limpar Transacoes");
                System.out.println("3- Voltar");
                int selecao2 = scanner.nextInt();
                if (selecao2 == 1) {
                    entrada.visualizarDados();
                } else if (selecao2 == 2) {
                    System.out.println("Informe a senha para limpar as Transacoes: ");
                    String senha = scanner.next();
                    if (senha.equals("abcd")) {
                        entrada.removerDados();
                        System.out.println("Transacoes limpa com sucesso");
                    } else if (selecao2 == 3) {
                        continue;
                    }
                }
            }

            if (selecao1 == 6) {
                menu = false;
                System.out.println("Programa Finalizado!");
            }
        }

    }
}