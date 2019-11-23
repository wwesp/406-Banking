package GUI;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.People.Customer;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class manager_create_credit {
    private JPanel manager_create_credit_panel;
    private JTextField textField3;
    private JButton back_button;
    private JButton accept_button;
    private JLabel snn_label;
    private Double credit_limit;

    public static void main(String[] args) {
        new manager_loan_credit();
    }

    public manager_create_credit(String customer){
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_create_credit_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        snn_label.setText(customer);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_create_loan manager_create_loan = new manager_create_loan(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    credit_limit = new SystemHelper().truncOrRound(Double.parseDouble(textField3.getText()), 0);
                    CreditCard new_cc = new CreditCard(customer,credit_limit);

                    ArrayList<CreditCard> fuckYOUWILL = new ArrayList<>();
                    fuckYOUWILL.add(new_cc);

                    SaveData new_save = new SaveData();
                    new_save.saveCC(fuckYOUWILL);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                }

            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    credit_limit = new SystemHelper().truncOrRound(Double.parseDouble(textField3.getText()), 0);
                    CreditCard new_cc = new CreditCard(customer,credit_limit);

                    ArrayList<CreditCard> fuckYOUWILL = new ArrayList<>();
                    fuckYOUWILL.add(new_cc);

                    SaveData new_save = new SaveData();
                    new_save.saveCC(fuckYOUWILL);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                }

            }
        });
    }
}
