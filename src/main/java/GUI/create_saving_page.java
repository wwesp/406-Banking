package GUI;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.RegSavings;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class create_saving_page extends JFrame{
    private JPanel create_saving_page;
    private JButton accept_button;
    private JButton back_button;
    private JTextField balance_text;
    private JLabel SSN_label;
    private JComboBox term_drop_down;
    private JRadioButton savingsRadioButton;
    private JRadioButton certificateOfDepositRadioButton;
    private int term;

    public static void main(String[] args) {
        new create_saving_page(0, null);
    }

    public create_saving_page(int x, String SSN) {
        JFrame frame = new JFrame("Create Savings Account");
        frame.setContentPane(create_saving_page);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SSN_label.setText(SSN);

        term_drop_down.addItem("5");
        term_drop_down.addItem("10");
        term_drop_down.addItem("20");
        term_drop_down.addItem("50");

        if (x == 2){
            savingsRadioButton.setSelected(true);
            certificateOfDepositRadioButton.setEnabled(false);
            term_drop_down.setEnabled(false);
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == 2){
                    frame.setVisible(false);
                    teller_home teller_home = new teller_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));                }
                if (x == 3){
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (savingsRadioButton.isSelected()) {
                    double balance = Double.parseDouble(balance_text.getText());
                    RegSavings new_checking = new RegSavings(SSN, balance);
                    SaveData save_new_checking = new SaveData();
                    ArrayList<RegSavings> savings_arraylist = new ArrayList<>();
                    savings_arraylist.add(new_checking);
                    save_new_checking.saveSaving(savings_arraylist);
                }
                if (certificateOfDepositRadioButton.isSelected()){
                    double balance = Double.parseDouble(balance_text.getText());
                    term = Integer.parseInt(Objects.requireNonNull(term_drop_down.getSelectedItem()).toString());
                    CDs new_cd = new CDs(SSN, balance, term);
                    SaveData save_new_CD = new SaveData();
                    ArrayList<CDs> CD_arraylist = new ArrayList<>();
                    CD_arraylist.add(new_cd);
                    save_new_CD.saveCD(CD_arraylist);
                }

                JOptionPane.showMessageDialog(null, "The Account has Been Successfully Created");
                if (x == 2){
                    frame.setVisible(false);
                    teller_home teller_home = new teller_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));                }
                if (x == 3){
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });

        term_drop_down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        savingsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                certificateOfDepositRadioButton.setSelected(false);
                term_drop_down.enable(false);
            }
        });
        certificateOfDepositRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savingsRadioButton.setSelected(false);
                term_drop_down.enable(true);

            }
        });
    }
}
