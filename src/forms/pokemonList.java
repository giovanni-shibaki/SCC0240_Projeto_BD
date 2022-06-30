package forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class pokemonList {
    private JPanel panelMain;
    private JTable tblPokemon;
    private JScrollPane spPokemon;

    public pokemonList()
    {
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("pokemonList");
        frame.setContentPane(new pokemonList().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(700, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private static Object[][] fetchData()
    {
        return null;
    }
}
