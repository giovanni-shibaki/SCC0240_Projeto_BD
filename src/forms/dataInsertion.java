package forms;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import action.insertTrainer;

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
    private JFrame frame;

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
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar se os dados são válidos

                // Verificar se o campo CPF (obrigatório) não está preenchido
                if(!checkCPF()) {
                    JOptionPane.showMessageDialog(null, "Por favor insira um número válido de CPF!");
                    return;
                }

                // Verificar data
                if(!checkBirthDate()) {
                    JOptionPane.showMessageDialog(null, "A data inserida é inválida!");
                    return;
                }
                insertData();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpar todos os campos
                clearFields();
            }
        });

        ftxtCPF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cpfMoveMouse();
            }
        });
        ftxtDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                birthDateMoveMouse();
            }
        });

        frame = new JFrame("dataInsertion");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(800, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private void clearFields()
    {
        this.ftxtCPF.setText("");
        this.txtName.setText("");
        this.cmbGender.setSelectedIndex(0);
        this.ftxtDate.setText("");
        this.txtHomeTown.setText("");
        this.cmbTitle.setSelectedIndex(0);
    }

    private void cpfMoveMouse()
    {
        if(this.ftxtCPF.getText().compareTo("   -   -   -  ") == 0)
            this.ftxtCPF.setCaretPosition(0);
    }

    private void birthDateMoveMouse()
    {
        if(this.ftxtDate.getText().compareTo("  /  /    ") == 0)
            this.ftxtDate.setCaretPosition(0);
    }

    private boolean checkBirthDate()
    {
        // Campo de data vazio
        if(this.ftxtDate.getText().compareTo("  /  /    ") == 0)
            return true;

        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);

        try{
            Date jDate = sdfrmt.parse(this.ftxtDate.getText());
        }
        catch (ParseException e)
        {
            return false;
        }
        return true;
    }

    private boolean checkCPF()
    {
        String cpf = this.ftxtCPF.getText();
        if(cpf.compareTo("   -   -   -  ") == 0)
            return false;
        if(cpf.compareTo("000-000-000-00") == 0)
            return false;
        // Verificar se todos os caracteres estão preenchidos
        for(int i=0; i < cpf.length(); i++)
            if(!(cpf.charAt(i) == '-' || Character.isDigit(cpf.charAt(i))))
                return false;
        return true;
    }

    private void insertData()
    {
        // Enviar os dados preenchidos para a classe insertTrainer
        char gender;
        if(this.cmbGender.getSelectedItem().toString().compareTo("Male") == 0)
            gender = 'M';
        else if(this.cmbGender.getSelectedItem().toString().compareTo("Female") == 0)
            gender = 'F';
        else
            gender = 'O';

        try {
            insertTrainer inst = new insertTrainer(this.ftxtCPF.getText(), this.txtName.getText(), gender, this.ftxtDate.getText().compareTo("  /  /    ") == 0 ? null : this.ftxtDate.getText(), this.txtHomeTown.getText(), this.cmbTitle.getSelectedItem().toString());
            inst.insert();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
