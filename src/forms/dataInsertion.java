package forms;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class dataInsertion {
    private JLabel lblCPF;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblGender;
    private JComboBox cmbGender;
    private JLabel lblDate;
    private JFormattedTextField ftxtCPF;
    private JFormattedTextField ftxtDate;
    private JLabel lblHomeTown;
    private JTextField txtHomeTown;
    private JLabel lblTitle;
    private JComboBox cmbTitle;
    private JPanel panelMain;
    private JButton btnClear;
    private JButton btnSubmit;
    private JPanel panelButtons;

    public dataInsertion()
    {
        try {
            MaskFormatter cpfMask = new MaskFormatter("###-###-###-##");
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            cpfMask.install(this.ftxtCPF);
            dateMask.install(this.ftxtDate);
        } catch (Exception err) {
            // Erro ao inserir máscara nos campos de CPF e Data
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("dataInsertion");
        frame.setContentPane(new dataInsertion().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(800, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }
}
