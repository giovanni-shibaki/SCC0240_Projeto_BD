package forms;

import javax.swing.*;
import java.awt.*;

public class dataQuery {
    private JPanel panelMain;
    private JLabel lblName;
    private JCheckBox cbName;
    private JTextField txtName;
    private JCheckBox cbNumber;
    private JLabel lblNumber;
    private JLabel lblType1;
    private JLabel lblType2;
    private JCheckBox cbType1;
    private JCheckBox cbType2;
    private JTextField txtType1;
    private JTextField txtType2;
    private JButton btnClear;
    private JButton btnSubmit;
    private JPanel panelButtons;
    private JSpinner spnNumber;

    public dataQuery()
    {

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("dataQuery");
        frame.setContentPane(new dataQuery().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(700, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }
}
