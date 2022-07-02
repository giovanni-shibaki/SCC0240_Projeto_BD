package forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pokemonList {
    private JPanel panelMain;
    private JTable tblPokemon;
    private JScrollPane spPokemon;
    private JFrame frame;
    private ResultSet rs;
    private static Object[][] tableData;

    public pokemonList(ResultSet result)
    {
        this.rs = result;
        /*while(result.next()) {
            System.out.println(result.getString("Nome"));
        }*/

        this.tblPokemon.getTableHeader().setReorderingAllowed(false);
        this.tblPokemon.setModel(new DefaultTableModel(fetchData(),
                new String[] {
                        "Number", "Name", "Description", "Type 1", "Type 2"
                }
                ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        // Setando a largura de cada coluna
        this.tblPokemon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tblPokemon.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.tblPokemon.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tblPokemon.getColumnModel().getColumn(2).setPreferredWidth(370);
        this.tblPokemon.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.tblPokemon.setRowHeight(this.tblPokemon.getRowHeight() + 20);

        frame = new JFrame("pokemonList");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(700, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private Object[][] fetchData()
    {
        int numRows = 0;
        try{
            while(rs.next())
                numRows++;
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o resultado da busca na tabela!\nMensagem de erro: "+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }

        if(numRows == 0)
        {
            // Nenhum resultado encontrado para a busca
            JOptionPane.showMessageDialog(null, "Nenhum pokémon foi encontrado na busca com os parâmetros inseridos!", "Busca sem correspondencia!", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }

        tableData = new Object[numRows][];

        try{
            rs.beforeFirst();
            int index = 0;
            while(rs.next())
            {
                // NUMERO, NOME, DESCRICAO, TIPO_1, TIPO_2
                tableData[index] = new Object[] { rs.getInt("NUMERO"), rs.getString("NOME"), rs.getString("DESCRICAO"), rs.getString("TIPO_1"), rs.getString("TIPO_2") };
                index++;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o resultado da busca na tabela!\nMensagem de erro: "+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }
        return tableData;
    }
}
