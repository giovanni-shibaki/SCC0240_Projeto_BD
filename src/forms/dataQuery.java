package forms;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

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
    private JFrame frame;

    public dataQuery()
    {
        frame = new JFrame("dataQuery");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(700, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);

        spnNumber.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                checkNumberValue();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chamar o método da classe selectPokemon para realizar a quary
            }
        });
    }

    private void checkNumberValue()
    {
        if(Integer.parseInt(this.spnNumber.getValue().toString()) > 1000000)
            this.spnNumber.setValue(1000000);
        if(Integer.parseInt(this.spnNumber.getValue().toString()) < 0)
            this.spnNumber.setValue(0);
    }

    private void clearFields()
    {
        this.cbNumber.setSelected(false);
        this.spnNumber.setValue(0);
        this.cbName.setSelected(false);
        this.txtName.setText("");
        this.cbType1.setSelected(false);
        this.txtType1.setText("");
        this.cbType2.setSelected(false);
        this.txtType2.setText("");
    }
}
