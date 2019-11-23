package GUI;

import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.RegSavings;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class manager_create_short_long_loan {
    private JPanel short_long_panel;
    private JComboBox year_type_combo_box;
    private JLabel ssn_label;
    private JLabel loan_type_label;
    private JTextField textField1;
    private JButton accept_button;
    private JButton back_button;
    private String year_type;
    private Double balance;

    public static void main(String[] args) {
        new manager_create_short_long_loan(null);
    }

    public manager_create_short_long_loan(String customer) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(short_long_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ssn_label.setText(customer);

        year_type_combo_box.addItem("1");
        year_type_combo_box.addItem("2");
        year_type_combo_box.addItem("3");
        year_type_combo_box.addItem("4");
        year_type_combo_box.addItem("5");
        year_type_combo_box.addItem("15");
        year_type_combo_box.addItem("30");


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (year_type.equals("30") || year_type.equals("15")) {
                    try {
                        balance = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);

                        year_type = Objects.requireNonNull(year_type_combo_box.getSelectedItem()).toString();

                        LongTermLoan long_loan = new LongTermLoan(customer,year_type, balance);

                        ArrayList<LongTermLoan> new_lt = new ArrayList<>();
                        new_lt.add(long_loan);

                        SaveData new_long_loan = new SaveData();
                        new_long_loan.saveLongLoan(new_lt);

                        JOptionPane.showMessageDialog(null, "The Loan has been Created");
                        frame.setVisible(false);
                        manager_home manager_home = new manager_home();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }
                } else {
                    try {
                        balance = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);

                        year_type = Objects.requireNonNull(year_type_combo_box.getSelectedItem()).toString();

                        ShortTermLoan short_term = new ShortTermLoan(customer, year_type, balance);

                        ArrayList<ShortTermLoan> new_st = new ArrayList<>();
                        new_st.add(short_term);

                        SaveData new_short_loan = new SaveData();
                        new_short_loan.saveShortLoan(new_st);

                        JOptionPane.showMessageDialog(null, "The Loan has been Created");
                        frame.setVisible(false);
                        manager_home manager_home = new manager_home();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }
                }


            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (year_type.equals("30") || year_type.equals("15")) {
                    try {
                        balance = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);

                        year_type = Objects.requireNonNull(year_type_combo_box.getSelectedItem()).toString();

                        LongTermLoan long_loan = new LongTermLoan(customer,year_type, balance);

                        ArrayList<LongTermLoan> new_lt = new ArrayList<>();
                        new_lt.add(long_loan);

                        SaveData new_long_loan = new SaveData();
                        new_long_loan.saveLongLoan(new_lt);

                        JOptionPane.showMessageDialog(null, "The Loan has been Created");
                        frame.setVisible(false);
                        manager_home manager_home = new manager_home();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }
                } else {
                    try {
                        balance = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);

                        year_type = Objects.requireNonNull(year_type_combo_box.getSelectedItem()).toString();

                        ShortTermLoan short_term = new ShortTermLoan(customer, year_type, balance);

                        ArrayList<ShortTermLoan> new_st = new ArrayList<>();
                        new_st.add(short_term);

                        SaveData new_short_loan = new SaveData();
                        new_short_loan.saveShortLoan(new_st);

                        JOptionPane.showMessageDialog(null, "The Loan has been Created");
                        frame.setVisible(false);
                        manager_home manager_home = new manager_home();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }
                }
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_create_loan manager_create_loan = new manager_create_loan(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        year_type_combo_box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year_type = Objects.requireNonNull(year_type_combo_box.getSelectedItem()).toString();
                if (year_type.equals("30") || year_type.equals("15")){
                    loan_type_label.setText("Long Term Loan");
                }
                else {
                    loan_type_label.setText("Short Term Loan");
                }
            }
        });
    }
}
