package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import forms.dataInsertion;
import forms.dataQuery;

public class mainPage {
    private JPanel panel1;
    private JPanel panelMain;
    private JButton btnInsert;
    private JButton btnQuery;
    private JFrame frame;

    public mainPage() {

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDataInsertion();
            }
        });
        btnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDataQuery();
            }
        });

        frame = new JFrame("Main Page");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Trainer Insertion");
        frame.setSize(800, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    private void openDataInsertion()
    {
        new dataInsertion();
    }

    private void openDataQuery()
    {
        new dataQuery();
    }
}
