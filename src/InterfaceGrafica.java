import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

public class InterfaceGrafica {
    public void painelPrincipal() {
        JFrame frame = new JFrame("Sistema de Gerenciamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel painelPrincipal = new JPanel(new GridLayout(3, 1, 10, 10));

        painelPrincipal.add(criarPainelTabela("Estoque", "src/BancoDeDados/estoque.csv", new String[]{"ID", "Tipo", "Nome", "Quantidade", "Preço"}));
        painelPrincipal.add(criarPainelTabela("Pessoas", "src/BancoDeDados/pessoas.csv", new String[]{"ID", "Tipo", "Nome", "Cargo"}));
        painelPrincipal.add(criarPainelTabela("Transações", "src/BancoDeDados/transacoes.csv", new String[]{"ID", "Tipo", "Produto", "Horario"}));

        frame.add(painelPrincipal);
        frame.setVisible(true);
    }

    private JPanel criarPainelTabela(String titulo, String caminhoCSV, String[] colunas) {
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBorder(BorderFactory.createTitledBorder(titulo));

        DefaultTableModel modeloTabela = new DefaultTableModel();
        JTable tabela = new JTable(modeloTabela);

        for (String coluna : colunas) {
            modeloTabela.addColumn(coluna);
        }

        carregarDadosCSV(modeloTabela, caminhoCSV);

        JScrollPane scrollPane = new JScrollPane(tabela);
        painelTabela.add(scrollPane, BorderLayout.CENTER);

        return painelTabela;
    }

    private void carregarDadosCSV(DefaultTableModel modeloTabela, String caminhoCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                modeloTabela.addRow(linha);
            }
        } catch (IOException | CsvValidationException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + e.getMessage());
        }
    }

}



