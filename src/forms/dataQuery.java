package forms;

import action.selectPokemon;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class dataQuery {
    private JPanel panelMain;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblNumber;
    private JLabel lblType1;
    private JLabel lblType2;
    private JTextField txtType1;
    private JTextField txtType2;
    private JButton btnClear;
    private JButton btnSubmit;
    private JPanel panelButtons;
    private JFormattedTextField ftxtNumber;
    private JFrame frame;

    public dataQuery()
    {
        try {
            MaskFormatter numberMask = new MaskFormatter("#######");
            numberMask.install(this.ftxtNumber);
        } catch (Exception err) {
            // Erro ao inserir máscara nos campos de CPF e Data
        }

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
                queryPokemon();
            }
        });

        frame = new JFrame("dataQuery");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(700, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
        ftxtNumber.addMouseListener(new MouseAdapter() {
        });
        ftxtNumber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberMoveMouse();
            }
        });
    }

    private void clearFields()
    {
        this.ftxtNumber.setText("");
        this.txtName.setText("");
        this.txtType1.setText("");
        this.txtType2.setText("");
    }

    private void numberMoveMouse()
    {
        if(this.ftxtNumber.getText().compareTo("       ") == 0)
            this.ftxtNumber.setCaretPosition(0);
    }

    private void queryPokemon()
    {
        // Checar se pelo menos 1 dos parametros de busca está preenchido
        if((this.ftxtNumber.getText().compareTo("       ") == 0 || this.ftxtNumber.getText().compareTo("") == 0) && this.txtName.getText().compareTo("") == 0 && this.txtType1.getText().compareTo("") == 0 && this.txtType2.getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null, "Por favor preencha pelo menos um parâmetro de busca!", "Parametros inválidos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            //public selectPokemon(Integer number, String name, String type1, String type2)
            selectPokemon inst = new selectPokemon(this.ftxtNumber.getText().trim().compareTo("") == 0 ? null : Integer.parseInt(this.ftxtNumber.getText().trim()), this.txtName.getText(), this.txtType1.getText(), this.txtType2.getText());
            inst.search();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
